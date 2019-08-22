package com.myheart.heap;


/**
 * @author yangxin
 * @date 2019/8/21
 */
public class HeapStructure {

    private int heapCapacity = 16;

    private int heapLength = 0;

    private HeapNode[] heapNodes;

    public HeapStructure(int heapCapacity) {
        this.heapCapacity = heapCapacity;
        this.heapNodes = new HeapNode[this.heapCapacity];
    }
    public HeapStructure() {
        this.heapNodes = new HeapNode[this.heapCapacity];
    }

    public boolean addElement(int element){
        if (heapLength == heapCapacity){
            return false;
        }
        heapNodes[heapLength] = new HeapNode(element,heapLength);
        heapLength++;
        adjustUp(heapNodes[heapLength-1]);
        return true;
    }

    public int peek(){
        return heapNodes[heapLength-1].element;
    }

    public int pop(){
        HeapNode heapNode = heapNodes[0];
        swapNode(0,heapLength-1);
        heapNodes[heapLength-1] = null;
        heapLength--;
        adjustDown();
        return heapNode.element;
    }

    public int swapTop(int element){
        HeapNode heapNode = heapNodes[0];
        heapNodes[0] = new HeapNode(element,0);
        adjustDown();
        return heapNode.element;
    }

    private void adjustDown(){
        adjustDown(heapNodes[0]);
    }

    private void adjustDown(HeapNode heapNodeBase){
        HeapNode leftNode = leftNode(heapNodeBase);
        HeapNode rightNode = rightNode(heapNodeBase);
        //如果 右节点不空，则左节点一定不空
        //如果 右节点为空，则candidateNode为左节点，仍为空，则不需要调整
        HeapNode candidateNode = rightNode == null ? leftNode : null;
        if (candidateNode == null && leftNode != null){
            candidateNode = leftNode.element > rightNode.element ? leftNode : rightNode;
        }
        if(candidateNode != null && candidateNode.element > heapNodeBase.element){
            int indexBase = candidateNode.index;
            swapNode(indexBase,heapNodeBase.index);
            adjustDown(heapNodes[indexBase]);
        }
    }

    private void adjustUp(HeapNode heapNodeBase){
        HeapNode parentNode = parentNode(heapNodeBase);
        if (parentNode != null && heapNodeBase.element > parentNode.element){
            int indexBase = parentNode.index;
            swapNode(indexBase,heapNodeBase.index);
            adjustUp(heapNodes[indexBase]);
        }
    }


    private HeapNode leftNode(HeapNode parent){
        int indexLeft = parent.index*2+1;
        if (indexLeft >= heapLength) {
            return null;
        }
        return heapNodes[indexLeft];
    }
    private HeapNode rightNode(HeapNode parent){
        int indexRight = parent.index*2+2;
        if (indexRight >= heapLength) {
            return null;
        }
        return heapNodes[indexRight];
    }
    private HeapNode parentNode(HeapNode heapNode){
        int indexParent = (heapNode.index-1)/2;
        if (indexParent < 0){
            return null;
        }
        return heapNodes[indexParent];
    }

    private void swapNode(int heapNodeFrom, int heapNodeTo){
        HeapNode heapNodeTmp = heapNodes[heapNodeTo];
        heapNodes[heapNodeTo] = heapNodes[heapNodeFrom];
        heapNodes[heapNodeTo].index = heapNodeTo;
        heapNodes[heapNodeFrom] = heapNodeTmp;
        heapNodes[heapNodeFrom].index = heapNodeFrom;
    }

    public void printHeap(){
        int level = bitCount();
        int index = 0;
        for (int i = 1; i <= level; i++) {
            index = printHeapByLevel(i,index);
        }


    }

    private int printHeapByLevel(int level, int start){
        int index = start;
        for (int i = 0; i < Math.pow(2,level-1) && index < heapLength; i++,index++){
            System.out.print(heapNodes[index].element+" ");
        }
        return index;
    }

    private int bitCount(){
        int n = heapLength;
        int result = 0;
        while (n > 0){
            n = n >> 1;
            result++;
        }
        return result;
    }


    private class HeapNode{

        private int element;
        private int index;

        public HeapNode(int element, int index) {
            this.element = element;
            this.index = index;
        }
    }

}
