package test.annotation;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/6/27
 */
public class TT {

    public static void main(String[] args)throws Exception {
        long start = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder();
        for(int i =0; i < 50000; i++) {
            sb.append("呃" + i);
        }
        /*String s1 = "";
        for(int i =0; i < 50000; i++) {
            s1 += ("呃" + i);
        }*/
        long end = System.currentTimeMillis();
        System.out.println(end - start);

       /* //1. 得到字节码
        Class<Person> pclazz = Person.class;
        //2. 找到对应字段
        Field pField = pclazz.getDeclaredField("name");
        //3. 解析字段上的注解
        Annotation anotationNameOfField = pField.getAnnotation(MyAnotation.class);
        Class<? extends Annotation> myAnotationClazz = anotationNameOfField.getClass();
        Method methodValueInMyAnotation = myAnotationClazz.getMethod("value");
        String name = (String)methodValueInMyAnotation.invoke(anotationNameOfField);
        //4. 输出注解上值
         System.out.println(name);*/
    }

}
