package com.myheart;

/**
 * @author yangxin
 * @date 2019/12/18
 */
public class Container {

    public static int value = 5;

    private final ConstantValue constantValue;

    public Container() {
        this.constantValue = new ConstantValue();
    }

    public void say(){
        System.out.println("Container!");
        constantValue.say();
    }
}
