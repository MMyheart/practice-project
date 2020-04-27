package com.myheart.sort;

/**
 * @author yangxin
 * @date 2020/2/19
 */
public class Selection implements Sort {
    @Override
    public void sort(int[] source) {
        for (int i = 0; i < source.length - 1; i++){
            int minIndex = i;
            for (int j = i + 1; j < source.length; j++){
                if (source[j] < source[minIndex]){
                    minIndex = j;
                }
            }
            int temp = source[i];
            source[i] = source[minIndex];
            source[minIndex] = temp;
        }
    }
}
