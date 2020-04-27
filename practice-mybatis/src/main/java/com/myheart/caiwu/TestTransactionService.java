package com.myheart.caiwu;

import com.myheart.caiwu.entity.CoreProductGroup;
import com.myheart.caiwu.mappers.CoreProductGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author yangxin
 * @date 2019/11/20
 */
@Service
public class TestTransactionService {

//    @Autowired
//    private CoreProductGroupMapper coreProductGroupMapper;

    @Transactional(rollbackFor = Exception.class)
    public void testTransaction(){
        CoreProductGroup coreProductGroup  = new CoreProductGroup();
        coreProductGroup.setId(99999L);
        coreProductGroup.setRequestSource("test");
        coreProductGroup.setAssetLevel("T");
        coreProductGroup.setPeriod(0);
        coreProductGroup.setPaySource("*");
        coreProductGroup.setCreateTime(new Date());
        coreProductGroup.setUpdateTime(new Date());
//        coreProductGroupMapper.insert(coreProductGroup);

        new Thread(new Runnable() {
            @Override
            public void run() {
                CoreProductGroup coreProductGroup  = new CoreProductGroup();
                coreProductGroup.setId(8888L);
                coreProductGroup.setRequestSource("test");
                coreProductGroup.setAssetLevel("T");
                coreProductGroup.setPeriod(0);
                coreProductGroup.setPaySource("*");
                coreProductGroup.setCreateTime(new Date());
                coreProductGroup.setUpdateTime(new Date());
//                coreProductGroupMapper.insert(coreProductGroup);
            }
        }).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = 1/0;

    }
}
