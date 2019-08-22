package com.myheart.testmain;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * @author yangxin
 * @date 2019/8/22
 */
public class ClassTest {


    public static void main(String[] args) {
        testClass5();
    }

    private static void print(Class<?> c){
        try {
            Class cl = c.getClassLoader().getClass();
            Method method = ReflectionUtils.findMethod(cl,"findLoadedClass",String.class);
            if (method == null){
                System.out.println("ReflectionUtils.findMethod 找不到 ClassLoader.findLoadedClass()");
                return;
            }
            method.setAccessible(true);
            if (method.invoke(c.getClassLoader(),"com.myheart.testmain.ClassTest$B") != null){
                System.out.println("com.myheart.testmain.ClassTest$B 已经加载！");
            }else {
                System.out.println("com.myheart.testmain.ClassTest$B 尚未加载！");
            }
            if (method.invoke(c.getClassLoader(),"com.myheart.testmain.ClassTest$A") != null){
                System.out.println("com.myheart.testmain.ClassTest$A 已经加载！");
            }else {
                System.out.println("com.myheart.testmain.ClassTest$A 尚未加载！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * B.class
     * 加载B.class文件，同时加载父类A.class文件
     * 经过验证阶段、准备阶段的赋初值
     * 不会执行<clinit>方法
     */
    private static void testClass1(){
        Class c = B.class;
        print(c);
    }

    /**
     * Class.forName(b)
     * 加载B.class文件，同时加载父类A.class文件
     * 经过验证阶段、准备阶段的赋初值
     * 执行<clinit>方法
     */
    private static void testClass2(){
        try {
            Class c = Class.forName("com.myheart.testmain.ClassTest$B");
            print(c);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Class.forName(b,true,classLoader)
     * 加载B.class文件，同时加载父类A.class文件
     * 经过验证阶段、准备阶段的赋初值
     * 执行<clinit>方法
     */
    private static void testClass3(){
        try {
            Class c = Class.forName("com.myheart.testmain.ClassTest$B",true,Thread.currentThread().getContextClassLoader());
            print(c);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Class.forName(b,false,classLoader)
     * 加载B.class文件，同时加载父类A.class文件
     * 经过验证阶段、准备阶段的赋初值
     * 不执行<clinit>方法
     */
    private static void testClass4(){
        try {
            Class c = Class.forName("com.myheart.testmain.ClassTest$B",false,Thread.currentThread().getContextClassLoader());
            print(c);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Class.forName(b,false,classLoader).newInstance()
     * 加载B.class文件，同时加载父类A.class文件
     * 经过验证阶段、准备阶段的赋初值
     * 执行<clinit>方法
     * 执行<init>方法
     */
    private static void testClass5(){
        try {
            B b = (B)Class.forName("com.myheart.testmain.ClassTest$B").newInstance();
            print(b.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    static class A{
        public A(){
            System.out.println("A Construct");
        }
        {
            System.out.println("A instance");
        }
        static {
            System.out.println("A static");
        }
    }

    static class B extends ClassTest.A {

        private int a;

        public void setA(int a){
            this.a = a;
        }
        public B(){
            System.out.println("B Construct");
        }
        {
            System.out.println("B instance");
        }
        static {
            System.out.println("B static");
        }
    }




}
