package com.myheart.controller;

import com.myheart.MybatisBootApplication;
import com.myheart.caiwu.ITestService;
import com.myheart.caiwu.mappers.CoreProductGroupMapper;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author yangxin
 * @date 2019/8/7
 */
@RunWith(JMockit.class)
@SpringBootTest(classes = MybatisBootApplication.class)
public class TestControllerTest {


    @Tested
    private TestController testController;
    @Injectable
    private CoreProductGroupMapper coreProductGroupMapper;
    @Injectable
    private ITestService testService;

    @Test
    public void testTestMybatisEntrance() throws Exception {
        testController.testMybatisEntrance();
    }

}