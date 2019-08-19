package com.myheart.jdk;

/**
 * @author yangxin
 * @date 2019/8/13
 */
public class Chinese implements InterceptorChain {

    @Override
    public void process() {

        System.out.println("有请：");
    }
}
