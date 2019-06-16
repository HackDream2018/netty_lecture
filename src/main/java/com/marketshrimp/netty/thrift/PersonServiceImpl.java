package com.marketshrimp.netty.thrift;

import com.marketshrimp.thrift.generated.DataException;
import com.marketshrimp.thrift.generated.Person;
import com.marketshrimp.thrift.generated.PersonService;
import org.apache.thrift.TException;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 服务端引用thrift的接口文件
 * @date: 2019/6/16
 */
public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("Got Client Parameter: " + username);
        Person person = new Person();
        person.setUsername("服务端的田翔");
        person.setAge(24);
        person.setMarried(false);
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("Client Parameter:");
        System.out.println(person.getUsername());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }
}
