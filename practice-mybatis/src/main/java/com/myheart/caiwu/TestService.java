package com.myheart.caiwu;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yangxin
 * @date 2019/8/7
 */
@Service
public class TestService implements ITestService{

    private String name = "test";



    @Transactional
    @Override
    public String getName(){
        System.out.println(name);
        say();
        return name;
    }
    @Override
    public void say(){
        System.out.println("test inner method!");
    }


}
