package com.myheart.testmain;

/**
 * @author yangxin
 * @date 2019/11/1
 */
public class PairSub extends Pair<String> {

    @Override
    public void set(String f){
        System.out.println(getClass().getSimpleName());
    }

}
