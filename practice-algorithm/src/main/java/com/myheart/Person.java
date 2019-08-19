package com.myheart;

/**
 * @author yangxin
 * @date 2019/8/15
 */
public class Person extends Man {


    @Override
    public void say() {
        System.out.println("I'm Person!");
        sayBak();
    }

    public void sayBak(){
        super.say();
    }

    @Override
    public void speak(){
        System.out.println("Speak Person!");
        speakBck();
    }

    public void speakBck(){
        super.speak();
    }

}
