package test.designpattern.sevenidea.dependentinversion.violationreponsibility;

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
        public void receive(Email email) {
             System.out.println(email.getInfo());
        }

        public void receive(WeChat weChat) {
            System.out.println(weChat.getInfo());
        }
    }

    class Email {
        public String getInfo() {
            return "电子邮件信息";
        }
    }

    class WeChat {
        public String getInfo() {
            return "微信信息";
        }
    }
    
}
