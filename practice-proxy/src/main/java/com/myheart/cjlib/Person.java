package com.myheart.cjlib;

import com.myheart.jdk.Man;

/**
 * @author yangxin
 * @date 2019/8/13
 */
public class Person implements Man {

    private String name;

    private String language;

    public Person() {
        name = "Test";
        language = "Chinese";
    }

    @Override
    public void say(){
        System.out.println("I'm "+name+", I can speak "+language+"【test "+ hashCode() +"】");
        hello();
    }

    public void hello(){
        System.out.println("hello");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
