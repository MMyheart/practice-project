package com.myheart.controller;

import com.myheart.annotation.TestAnnotation;
import com.myheart.caiwu.ITestService;
import com.myheart.caiwu.TestService;
import com.myheart.caiwu.entity.CoreProductGroup;
import com.myheart.caiwu.mappers.CoreProductGroupMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author yangxin
 * @date 2019/8/6
 */
@Slf4j
@Controller
@RequestMapping(value = "test")
public class TestController {

    @Autowired
    private CoreProductGroupMapper coreProductGroupMapper;
    @Autowired
    private ITestService testService;

    @RequestMapping(value = "testMybatisEntrance", method = RequestMethod.GET)
    @ResponseBody
    @TestAnnotation(444)
    public String testMybatisEntrance(){
        CoreProductGroup coreProductGroup = coreProductGroupMapper.queryByPrimaryKey(2L);
        System.out.println(coreProductGroup.toString());
        System.out.println(testService.getName());
        return "success";
    }

    @RequestMapping(value = "testTestService", method = RequestMethod.GET)
    @ResponseBody
    public String testTestService(){
        testService.getName();
        return "success";
    }

    public static void main(String[] args) {
        Method method = null;
        try {
            method = TestController.class.getDeclaredMethod("testMybatisEntrance");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        TestAnnotation annotation = method.getAnnotation(TestAnnotation.class);
        System.out.println(annotation.tst());
        System.out.println(annotation.value());
        System.out.println(annotation.tttt());

    }

}
