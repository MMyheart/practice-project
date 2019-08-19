package com.myheart.cjlib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author yangxin
 * @date 2019/8/14
 */
public class CjlibTest {

    public static void main(String[] args) {

//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/apple/personalRepository/practice-project/practice-proxy/src/main/java/com/myheart/cjlib/proxy");

        Person person = new Person();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Person.class);
        enhancer.setCallback(new CglibProxyIntecepter(person));

        Person proxy = (Person)enhancer.create();
        proxy.say();

//        person.say();



    }

}
