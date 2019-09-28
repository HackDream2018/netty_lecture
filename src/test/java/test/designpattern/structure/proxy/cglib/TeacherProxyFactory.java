package test.designpattern.structure.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/28
 */
public class TeacherProxyFactory implements MethodInterceptor {
    // 维护一个目标对象
    private Object target;

    public TeacherProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 给目标对象生成其代理对象
     */
    public Object getProxyInstance() {
        // 1.创建增强类(猜测同静态和JDK代理一样, cglib在内存中对目标类新增了一个接口, 代理对象同目标对象一同实现了接口, 代理对象通过调用接口来调用目标对象)
        Enhancer enhancer = new Enhancer();
        // 2.设置父类
        enhancer.setSuperclass(target.getClass());
        // 3.设置回调函数
        enhancer.setCallback(this);
        // 4.创建代理对象
        return enhancer.create();
    }

    /**
     * 与JDK代理相似
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("Cglib代理开始~");
        // 调用目标对象的返回值(小田)
        Object value = method.invoke(target, args);
        System.out.println("Cglib代理提交~");
        return value;
    }
}
