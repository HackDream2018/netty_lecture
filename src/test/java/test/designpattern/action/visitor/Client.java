package test.designpattern.action.visitor;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/10/20
 */
public class Client {
    
    public static void main(String[] args) {
        // 创建数据结构元素客户端
        ObjectStructure structure = new ObjectStructure();
        ManElement man = new ManElement();
        WomanElement woman = new WomanElement();
        structure.attach(man);
        structure.attach(woman);

        // 成功的访问者来访问数据结构
        structure.display(new Success());

        // 失败的访问者来访问数据结构
        System.out.println("------------");
        structure.display(new Fail());
    }
    
}
