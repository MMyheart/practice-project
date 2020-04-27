package com.myheart.testmain;

/**
 * @author yangxin
 * @date 2019/11/1
 */
public class Pair<T> {

    private T feild;

    public void set(T f){
        System.out.println(getClass().getSimpleName());
        this.feild = f;
    }

    public T get(){
        return feild;
    }
}
