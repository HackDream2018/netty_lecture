package test.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/6/27
 */
public class TT {

    public static void main(String[] args)throws Exception {
        //1. 得到字节码
        Class<Person> pclazz = Person.class;
        //2. 找到对应字段
        Field pField = pclazz.getDeclaredField("name");
        //3. 解析字段上的注解
        Annotation anotation= pField.getAnnotation(MyAnotation.class);
        Class<? extends Annotation> myAnotationClazz = anotation.getClass();
        Method methodValueInMyAnotation = myAnotationClazz.getMethod("value");
        String name = (String)methodValueInMyAnotation.invoke(anotation);
        //4. 输出注解上值
         System.out.println(name);
    }

}
