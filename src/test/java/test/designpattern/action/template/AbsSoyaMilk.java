package test.designpattern.action.template;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/28
 */
public abstract class AbsSoyaMilk {
    // 模版方法, 加final不让子类覆盖
    protected final void make() {
        baseBeans();
        addBurden();
        soak();
        beat();
    }
    private void baseBeans() {
         System.out.println("第一步: 准备基础黄豆");
    }
    /**
     * 添加配料
     */
    abstract void addBurden();
    private void soak() {
         System.out.println("第三步: 浸泡豆类");
    }
    private void beat() {
         System.out.println("第四部: 将浸泡过后的黄豆和其他豆类放入豆浆机进行打磨");
    }
}
