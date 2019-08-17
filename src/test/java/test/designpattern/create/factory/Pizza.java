package test.designpattern.create.factory;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/10
 */
public abstract class Pizza {
    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    public void prepare() {
         System.out.println(String.format("%s 准备原材料", name));
    }

    public void bake() {
        System.out.println(String.format("%s 进行烘焙", name));
    }

    public void cut() {
        System.out.println(String.format("%s 进行分块", name));
    }

    public void box() {
        System.out.println(String.format("%s 进行打包", name));
    }
}
