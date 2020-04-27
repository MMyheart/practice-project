package com.myheart.bloofilter;

/**
 * @author yangxin
 * @date 2019/11/22
 */
public class BlooFilterForInteger {


    public static byte[] possibleValues = new byte[1000];
    private static final byte valueLength = 8;

    static {
        for (int i = 1; i< 20000; i++){
            int position = i % 1000;
            byte value = (byte)((i % valueLength) & 0xff);
            possibleValues[position] = value;
        }
    }

    public static boolean isExist(int testValue){
        int position = testValue % 1000;
        byte value = (byte)((testValue % valueLength) & 0xff);
        return possibleValues[position] == value;
    }


}
