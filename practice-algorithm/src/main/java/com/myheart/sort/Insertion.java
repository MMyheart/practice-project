package com.myheart.sort;

/**
 * @author yangxin
 * @date 2020/2/20
 */
public class Insertion implements Sort {
    @Override
    public void sort(int[] source) {
        if (source.length <= 1){
            return;
        }
        for (int i = 1; i < source.length - 1; i++){
            for (int j = 0; j < i; j++){
                if (source[i] < source[j]){
                    int temp = source[i];
                    for (int k = i - 1; k >= j; k--){
                        source[k+1] = source[k];
                    }
                    source[j] = temp;
                    break;
                }
            }
        }
    }
}
