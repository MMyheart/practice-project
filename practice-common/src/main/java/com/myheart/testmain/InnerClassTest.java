package com.myheart.testmain;

import com.myheart.innerclass.OutClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author yangxin
 * @date 2019/10/21
 */
public class InnerClassTest {

    public static void main(String[] args) {
        OutClass out;
        Class outClazz = OutClass.class;
        try {
            Constructor outConstructor = outClazz.getDeclaredConstructor();
            out = (OutClass) outConstructor.newInstance();
            out.say();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
