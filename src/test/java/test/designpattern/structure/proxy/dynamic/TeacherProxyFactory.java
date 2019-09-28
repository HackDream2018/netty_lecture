package test.designpattern.structure.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/28
 */
public class TeacherProxyFactory {
    // 维护一个目标对象
    private Object target;

    public TeacherProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 给目标对象生成其代理对象
     */
    public Object getProxyInstance() {
        // Proxy.newProxyInstance(目标类加载器, 目标类实现的接口, 调用目标类前触发的处理器)
        Object targetObj = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    /**
                     * proxy the proxy instance that the method was invoked on(可以理解为代理对象同样实现了与目标对象相同的接口, 代理对象通过接口调用目标对象)
                     * method: 目标对象实现的接口
                     * args: 目标对象实现的接口的接口参数
                     */
                    System.out.println("JDK代理开始~");
                    return method.invoke(target, args);
                });

        return targetObj;
    }
}
