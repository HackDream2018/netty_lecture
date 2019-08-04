package test.designpattern.sevenidea.dependentinversion;

import org.junit.Test;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/7/27
 */
public class DependentInversion3Transmit {

    @Test
    public void testMethod() {
        Person person = new Person();
        person.setIReceiver(new Email());
        person.receive();

        Person person2 = new Person();
        person2.setIReceiver(new WeChat());
        person2.receive();
    }
    
    class Person {
        IReceiver iReceiver;
        //3. set()赋值
        public void setIReceiver(IReceiver iReceiver) {
            this.iReceiver = iReceiver;
        }
        public void receive() {
            System.out.println(iReceiver.getInfo());
        }
    }
    /**
     * 只要是抽象的都行(抽象类/接口)
     */
    interface IReceiver {
        String getInfo();
    }
    class Email implements IReceiver{
        @Override
        public String getInfo() {
            return "电子邮件信息";
        }
    }
    class WeChat implements IReceiver{
        @Override
        public String getInfo() {
            return "微信信息";
        }
    }
    
}
