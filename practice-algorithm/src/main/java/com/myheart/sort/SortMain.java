package com.myheart.sort;

import java.util.Arrays;

/**
 * @author yangxin
 * @date 2020/2/19
 */
public class SortMain {
    public static void main(String[] args) {
        int[] source = new int[]{7, 3, 15, 4, 52, 5, 14, 10, 34, 36, 7, 8, 2, 18, 33, 13};
        Sort sort = new Bubble();
        sort.sort(source);
        System.out.println(Arrays.toString(source));

        sort = new Selection();
        sort.sort(source);
        System.out.println(Arrays.toString(source));

        sort = new Insertion();
        sort.sort(source);
        System.out.println(Arrays.toString(source));

        sort = new ShellInsertion();
        sort.sort(source);
        System.out.println(Arrays.toString(source));

        sort = new Merge();
        sort.sort(source);
        System.out.println(Arrays.toString(source));

        sort = new Quick();
        sort.sort(source);
        System.out.println(Arrays.toString(source));

    }
}
