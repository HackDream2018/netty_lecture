package test.designpattern.create.builder.usebuilder;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/24
 */
public class DirectorHouse {

    private AbstractHouse builder = null;

    public DirectorHouse(AbstractHouse builder) {
        this.builder = builder;
    }

    /**
     * 具体建造流程交给指挥者
     */
    public House build() {
        builder.buildBasic();
        builder.buildWalls();
        builder.roof();
        return builder.buildHouse();
    }
}
