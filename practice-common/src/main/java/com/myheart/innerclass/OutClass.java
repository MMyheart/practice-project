package com.myheart.innerclass;

/**
 * @author yangxin
 * @date 2019/10/21
 */
public class OutClass {

    private InnerClass innerClass;

    public void say(){
        System.out.println("out class!");
    }

    private static class InnerClass {

        private String name = "inner Class!";

        public void say(){
            System.out.println(name);
        }
    }
}
