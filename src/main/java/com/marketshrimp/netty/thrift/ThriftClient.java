package com.marketshrimp.netty.thrift;

import com.marketshrimp.thrift.generated.Person;
import com.marketshrimp.thrift.generated.PersonService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/6/16
 */
public class ThriftClient {
    private int port;
    private String address;

    public ThriftClient(int port, String address) {
        this.port = port;
        this.address = address;
    }

    public void run() {
        // 客户端
        TFramedTransport transport = new TFramedTransport(new TSocket(address, port, 600));
        // 协议工厂
        TCompactProtocol protocol = new TCompactProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);
        try {
            // 打开通道
            transport.open();
            Person person = client.getPersonByUsername("服务端的田翔");
            System.out.println(person.getUsername());
            System.out.println(person.getAge());
            System.out.println(person.isMarried());

            System.out.println("-------------");
            Person person2 = new Person();
            person2.setUsername("来自客户端的田翔");
            person2.setAge(24);
            person2.setMarried(false);
            client.savePerson(person2);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            transport.close();
        }
    }

    public static void main(String[] args) {
        new ThriftClient(8080, "127.0.0.1").run();
    }

}
