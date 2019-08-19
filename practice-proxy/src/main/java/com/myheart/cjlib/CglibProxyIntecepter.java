package com.myheart.cjlib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author yangxin
 * @date 2019/8/14
 */
public class CglibProxyIntecepter implements MethodInterceptor{

    private Object target;

    public CglibProxyIntecepter(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("请："+method.getName());
        Object object = proxy.invokeSuper(obj,args);
//        Object object = proxy.invoke(target,args);
        return object;
    }
}
