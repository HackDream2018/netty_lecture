package test.designpattern.create.builder;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/24
 */
public abstract class AbstractHouse {
    protected abstract void buildBasic();
    protected abstract void buildWalls();
    protected abstract void roof();

    /**
     * 输出建造细节
     */
    public void build() {
        buildBasic();
        buildWalls();
        roof();
    }
}
