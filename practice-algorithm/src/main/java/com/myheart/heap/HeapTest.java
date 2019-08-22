package com.myheart.heap;

/**
 * @author yangxin
 * @date 2019/8/15
 */
public class HeapTest {


    public static void main(String[] args) {
        HeapStructure heapStructure = new HeapStructure();
        heapStructure.addElement(2);
        heapStructure.addElement(1);
        heapStructure.addElement(3);
        heapStructure.addElement(7);
        heapStructure.addElement(5);
        heapStructure.addElement(4);
        heapStructure.addElement(6);
        heapStructure.addElement(10);
        heapStructure.addElement(8);
        heapStructure.addElement(7);
        heapStructure.addElement(11);
        heapStructure.addElement(17);
        heapStructure.printHeap();
        System.out.println();
        heapStructure.pop();
        heapStructure.printHeap();

    }
}
