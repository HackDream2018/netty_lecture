package test;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/6/27
 */
public class TT {

    private String name = "外部内的成员变量name";
    public static void main(String[] args)throws Exception {
        TT outerTT = new TT();
        InnerDemo innerDemo = outerTT.new InnerDemo();
        innerDemo.test();
    }

    public class InnerDemo {
        private void test() {
             System.out.println("我是内部类方法 + " + name);
        }
    }

}