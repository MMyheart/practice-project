package com.myheart.jdk;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangxin
 * @date 2019/8/13
 */
public class InterceptorChains {


    private List<InterceptorChain> interceptorChains = new ArrayList<>();
    private Object target;

    public InterceptorChains(Object target) {
        this.target = target;
    }

    public List<InterceptorChain> getInterceptorChains() {
        return interceptorChains;
    }

    public void addInvocationChain(InterceptorChain interceptorChain){
        this.interceptorChains.add(interceptorChain);
    }

    public Object getTarget() {
        return target;
    }
}
