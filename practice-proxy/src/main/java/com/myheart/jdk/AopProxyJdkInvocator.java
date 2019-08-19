package com.myheart.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author yangxin
 * @date 2019/8/13
 */
public class AopProxyJdkInvocator implements InvocationHandler {

    private InterceptorChains interceptorChains;

    public AopProxyJdkInvocator(InterceptorChains interceptorChains) {
        this.interceptorChains = interceptorChains;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (interceptorChains.getInterceptorChains().size() > 0){
            new AopInvocation(interceptorChains,interceptorChains.getTarget(), method).process();
            return null;
        }
        return method.invoke(interceptorChains.getTarget(),args);
    }
}
