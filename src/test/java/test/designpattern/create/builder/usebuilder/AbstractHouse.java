package test.designpattern.create.builder.usebuilder;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/24
 */
public abstract class AbstractHouse {
    protected House house = new House();

    protected abstract void buildBasic();
    protected abstract void buildWalls();
    protected abstract void roof();

    /**
     * 返回产品
     */
        public House buildHouse() {
        return house;
    }
}
