package com.marketshrimp.protobuf.com.example.tutorial;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/6/9
 */
public class ProtoBufTest {
    public static void main(String[] args) throws Exception {
        // 通过构建器对象不断的添加字段, 最后build()
        com.example.tutorial.DataInfo.Student student = com.example.tutorial.DataInfo.Student.newBuilder()
                .setName("张三")
                .setAge(20)
                .setAddress("上海")
                .build();

        // 消息 -> 字节(用于网络传输)
        byte[] studentBytes = student.toByteArray();
        // 字节 -> 消息
        com.example.tutorial.DataInfo.Student student2 = com.example.tutorial.DataInfo.Student.parseFrom(studentBytes);
        System.out.println(student2.getName()); // 张三
        System.out.println(student2.getAge()); // 20
        System.out.println(student2.getAddress());// 上海
    }

}
