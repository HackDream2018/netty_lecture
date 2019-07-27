package test.designpattern.sevenidea.dependentinversion;

import org.junit.Test;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/7/27
 */
public class DependentInversion {

    @Test
    public void testMethod() {
        Person person = new Person();
        person.receive(new Email());
        person.receive(new WeChat());
    }
    
    class Person {
        public void receive(IReceiver iReceiver) {
             System.out.println(iReceiver.getInfo());
        }
    }
    /**
     * 只要是抽象的都行(抽象类/接口)
     */
    abstract class IReceiver {
        abstract String getInfo();
    }
    class Email extends IReceiver{
        @Override
        public String getInfo() {
            return "电子邮件信息";
        }
    }
    class WeChat extends IReceiver{
        @Override
        public String getInfo() {
            return "微信信息";
        }
    }
    
}
