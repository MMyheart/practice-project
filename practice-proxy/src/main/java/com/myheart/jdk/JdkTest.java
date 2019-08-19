package com.myheart.jdk;

import java.lang.reflect.Proxy;

/**
 * @author yangxin
 * @date 2019/8/13
 */
public class JdkTest {

    public static void main(String[] args) {

//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        Person person = new Person();

        InterceptorChain interceptorChain = new Chinese();
        InterceptorChains interceptorChains = new InterceptorChains(person);
        interceptorChains.addInvocationChain(interceptorChain);
        AopProxyJdkInvocator aopProxyJdkInvocator = new AopProxyJdkInvocator(interceptorChains);

        Man man = (Man) Proxy.newProxyInstance(person.getClass().getClassLoader(), new Class[]{Man.class}, aopProxyJdkInvocator);
        man.say();

        person.say();

    }

}
