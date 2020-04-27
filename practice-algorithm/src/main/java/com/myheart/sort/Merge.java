package com.myheart.sort;

/**
 * @author yangxin
 * @date 2020/2/20
 */
public class Merge implements Sort {
    @Override
    public void sort(int[] source) {
        merge(source, 0 , source.length - 1);
    }

    public void merge(int[] source, int start, int end){
        if(start == end){
            return;
        }
        if(start + 1 == end){
            if(source[start] > source[end]){
                int temp = source[start];
                source[start] = source[end];
                source[end] = temp;
            }
            return;
        }
        int middle = (end - start) / 2;
        merge(source, start,start + middle);
        merge(source, start + middle + 1, end);
        int i = start;
        int j = start + middle + 1;
        int[] result = new int[end - start + 1];
        int k = 0;
        while (i <= start + middle || j <= end){
            if (i > start + middle){
                while (k < result.length){
                    result[k++] = source[j++];
                }
                break;
            }
            if (j > end){
                while (k < result.length){
                    result[k++] = source[i++];
                }
                break;
            }
            if (source[i] < source[j]){
                result[k++] = source[i++];
            }else {
                result[k++] = source[j++];
            }
        }
        k = 0;
        while (k < result.length){
            source[start++] = result[k++];
        }
    }

}
