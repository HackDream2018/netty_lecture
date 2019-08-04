package test.ioc;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/7/5
 */
public class MySpring {

    /**
     * 读取对象无参构造上自定义注解内容, 利用对象中属性的setXX方法来给成员变量赋值
     * @param className 类路径
     */
    public Object getBean(String className) {
        Object obj = null;
        try {
            // 1. 获取字节码文件, 实例化对象
            Class clazz = Class.forName(className);
            Constructor constructor = clazz.getConstructor();
            obj = constructor.newInstance();
            // 2. 读取无参构造上注解的值
            Annotation annotation = constructor.getAnnotation(MyAnotation.class);
            Class annotationClazz = annotation.getClass();
            Method annotationMethod = annotationClazz.getMethod("value");
            String[] values = (String[])annotationMethod.invoke(annotation);
            // 3. 将注解中value()的返回内容, 依次赋值给对象的成员变量
            Field[] clazzFields = clazz.getDeclaredFields();
            for(int i = 0; i < clazzFields.length; i++) {
                // 获取属性的名字, 用名字找到set方法
                String fieldName = clazzFields[i].getName();
                StringBuffer buffer = new StringBuffer();
                String firstLetter = fieldName.substring(0, 1).toUpperCase();
                String surplusLetter = fieldName.substring(1);
                buffer.append("set").append(firstLetter).append(surplusLetter);
                // 找set()
                Class<?> fieldTypeClazz = clazzFields[i].getType();
                Method setMethod = clazz.getMethod(buffer.toString(), fieldTypeClazz);
                // 就char没有将字符串转换成指定的数据类型  比如new Interge("")
                setMethod.invoke(obj, fieldTypeClazz.getConstructor(String.class).newInstance(values[i]));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

}
