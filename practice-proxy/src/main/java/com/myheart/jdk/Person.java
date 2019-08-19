package com.myheart.jdk;

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
        System.out.println("I'm "+name+", I can speak "+language+"【test "+ getClass() +"】");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
