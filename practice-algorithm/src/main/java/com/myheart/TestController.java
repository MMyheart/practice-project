package com.myheart;

import com.myheart.bloofilter.BlooFilterForInteger;
import com.myheart.queue.ring.RingQueue;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.*;

/**
 * @author yangxin
 * @date 2019/8/15
 */
public class TestController {


    public static void main(String[] args) {
//        int testValue = 200;
//        System.out.println(BlooFilterForInteger.possibleValues[200]);
//        byte value = (byte)((testValue % 127) & 0xff);
//        System.out.println(value);
//        System.out.println(BlooFilterForInteger.isExist(200));
//

//        try {
//            int i = 1/0;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            throw e;
//        } finally {
//            System.out.println("错误");
//        }

        String test = "1";
        System.out.println(test.split(",").length);

        int n = 256;
        byte[] b = new byte[4];
        b[3] = (byte) (n & 0xff);
        b[2] = (byte) (n >> 8 & 0xff);
        b[1] = (byte) (n >> 16 & 0xff);
        b[0] = (byte) (n >> 24 & 0xff);
//        System.out.println(Integer.valueOf(new String(b, Charset.forName("UTF-8"))));


        int int1=b[0]&0xff;
        int int2=(b[1]&0xff)<<8;
        int int3=(b[2]&0xff)<<16;
        int int4=(b[3]&0xff)<<24;
        System.out.println(int1|int2|int3|int4);


    }


}
