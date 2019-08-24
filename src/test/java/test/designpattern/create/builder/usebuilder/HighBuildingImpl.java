package test.designpattern.create.builder.usebuilder;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/24
 */
public class HighBuildingImpl extends AbstractHouse {
    @Override
    protected void buildBasic() {
         System.out.println("高楼房- 打地基");
    }

    @Override
    protected void buildWalls() {
        System.out.println("高楼房- 砌墙");
    }

    @Override
    protected void roof() {
        System.out.println("高楼房- 封顶");
    }
}
