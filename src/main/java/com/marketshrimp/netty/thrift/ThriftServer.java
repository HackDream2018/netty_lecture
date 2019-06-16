package com.marketshrimp.netty.thrift;

import com.marketshrimp.thrift.generated.PersonService;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/6/16
 */
public class ThriftServer {

    private int port;
    private String address;
    public ThriftServer(int port, String address) {
        this.port = port;
        this.address = address;
    }

    public void run()throws Exception {
        // 服务端非阻塞Socket
        TNonblockingServerSocket socket = new TNonblockingServerSocket(port);
        // 高可用
        THsHaServer.Args arg = new THsHaServer.Args(socket).minWorkerThreads(2).maxWorkerThreads(4);
        // 服务处理器
        PersonService.Processor<PersonServiceImpl> processor = new PersonService.Processor<>(new PersonServiceImpl());
        // 协议工厂
        arg.protocolFactory(new TCompactProtocol.Factory());
        arg.transportFactory(new TFramedTransport.Factory());
        arg.processorFactory(new TProcessorFactory(processor));
        // 开启server
        TServer server = new THsHaServer(arg);
        System.out.println("Thrift Server started!");
        // 死循环
        server.serve();
    }
    public static void main(String[] args)throws Exception {
       new ThriftServer(8080, "").run();
    }

}
