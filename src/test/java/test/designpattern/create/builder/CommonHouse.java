package test.designpattern.create.builder;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/24
 */
public class CommonHouse extends AbstractHouse {
    @Override
    protected void buildBasic() {
         System.out.println("普通房- 打地基");
    }

    @Override
    protected void buildWalls() {
        System.out.println("普通房- 砌墙");
    }

    @Override
    protected void roof() {
        System.out.println("普通房- 封顶");
    }
}
