package com.myheart.sort;

/**
 * @author yangxin
 * @date 2020/2/20
 */
public class Quick implements Sort {
    @Override
    public void sort(int[] source) {
        quick3(source, 0 , source.length - 1);
    }

    private void quick(int[] source, int start, int end){
        if(start >= end){
            return;
        }
        int pivot = partition(source, start, end);
        quick(source, start, pivot-1);
        quick(source, pivot+1, end);
    }

    private int partition(int[] source, int start, int end){
        int pivot = source[start];
        int i = start;
        int j = end;
        do {
            // 不能 source[j] >= pivot, 如 0 0 0 0 0序列, 连续多个等于pivot,
            // 如果加=,会导致这些相等的值全都留在pivot一侧, 不加=,会交换i、j, 相等值均匀分在pivot两侧
            while(j > i && source[j] > pivot){
                j--;
            }
            while(i < j && source[i] < pivot){
                i++;
            }
            int temp = source[i];
            source[i] = source[j];
            source[j] = temp;
        }while (i < j);
        source[start] = source[i];
        source[i] = pivot;
        return i;
    }

    private void quick3(int[] source, int start, int end){
        if(start >= end){
            return;
        }
        int[] pivot = partition3(source, start, end);
        quick3(source, start, pivot[0]);
        quick3(source, pivot[1], end);
    }

    private int[] partition3(int[] source, int start, int end){
        int random = (int)(Math.random()*(end-start+1)+start);
        swap(source,random,start);
        int pivot = source[start];
        // source[start+1...lt] < pivot
        // source[lt+1...i-1] = pivot
        // source[i...gt-1] 待处理
        // source[gt...end] > pivot
        int i = start + 1;
        int lt = start;
        int gt = end+1;
        while (i < gt){
            if (source[i] < pivot){
                swap(source, i, lt+1);
                lt++;
                i++;
            }else if (source[i] > pivot){
                swap(source, i, gt-1);
                gt--;
            }else {
                i++;
            }
        }
        swap(source, start, lt);
        int[] result = new int[2];
        result[0] = lt-1;
        result[1] = gt;
        return result;
    }

    private void swap(int[] source, int i, int j){
        int temp = source[i];
        source[i] = source[j];
        source[j] = temp;
    }
}
