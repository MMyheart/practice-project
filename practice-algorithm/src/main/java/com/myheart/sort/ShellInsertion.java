package com.myheart.sort;

/**
 * @author yangxin
 * @date 2020/2/20
 */
public class ShellInsertion implements Sort {
    @Override
    public void sort(int[] source) {
        int gap = source.length / 2;
        while (gap > 0){
            for (int i = gap; i < source.length; i++){
                int current = source[i];
                int preIndex = i - gap;
                while (preIndex > 0 && current < source[preIndex]){
                    source[preIndex + gap] = source[preIndex];
                    preIndex -= gap;
                }
                source[preIndex + gap] = current;
            }
            gap /= 2;
        }
    }
}
