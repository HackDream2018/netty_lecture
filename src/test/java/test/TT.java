package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/6/27
 */
public class TT {

    @Test
    public void testMethod() {
        List<Man> list = new ArrayList<>();
        list.add(new Man("田翔", 24));
        list.add(new Man("田翔2", 24));
        list.add(new Man("田翔3", 23));
        list.add(new Man("田翔3", 24));
        // 加了Function.identity()后, 键不能重复, (key1, key2) -> key2 表示取后面的值
        Map<String, Man> map = list.stream().collect(Collectors.toMap(Man::getName, Function.identity(), (key1, key2) -> key2));
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