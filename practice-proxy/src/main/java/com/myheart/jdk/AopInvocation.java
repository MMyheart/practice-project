package com.myheart.jdk;

import java.lang.reflect.Method;

/**
 * @author yangxin
 * @date 2019/8/13
 */
public class AopInvocation {

    private InterceptorChains interceptorChains;
    private Object target;
    private Method method;

    public AopInvocation(InterceptorChains interceptorChains, Object target, Method method) {
        this.interceptorChains = interceptorChains;
        this.target = target;
        this.method = method;
    }

    public void process() throws Exception{

        for (InterceptorChain interceptor : interceptorChains.getInterceptorChains()){
            interceptor.process();
        }
        method.invoke(target,null);
    }


}
