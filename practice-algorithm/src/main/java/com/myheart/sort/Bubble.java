package com.myheart.sort;

import java.util.List;

/**
 * @author yangxin
 * @date 2020/2/19
 */
public class Bubble implements Sort {

    @Override
    public void sort(int[] source) {
        for (int i = 0; i < source.length - 1; i++){
            for (int j = 0; j < source.length - i - 1; j++){
                if (source[j] > source[j+1]){
                    Integer temp = source[j];
                    source[j] = source[j+1];
                    source[j+1] = temp;
                }
            }
        }
    }

}

