package test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/6/27
 */
public class TT {

    @Test
    public void testMethod() {
      Map<String, String> map = new HashMap<>();
        String s = map.get("1");

    }

    class Man {
        private String name;
        private Integer age;

        public Man(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}