package pratice.算法第一次上机.two;

import java.util.Arrays;

/**
 * Created by pro on 17/3/22.
 * 最小堆
 */
public class PriorityQueue {
    private int size=0;

    private int[] heap;

    private final int DEFAULT_SIZE=16;

    public PriorityQueue(int[] origin){
        init(origin);
    }
    public PriorityQueue(){}

    //给定数组 建堆
    private void init(int[] origin){
        if(origin!=null) {
            size = origin.length;
            heap =copyOf(origin);
            for (int i=origin.length; i> 0; --i) {
                int father=i/2;
                if (heap[i] < heap[father]) {
                    swap(heap, i, father);
                    downBalance(i);
                }
            }
        }
        else {
            heap = new int[DEFAULT_SIZE+1];
        }
    }

    private int[] copyOf(int[] origin) {
        int[] a=new int[origin.length+1];
        for (int i = 1; i <=origin.length ; i++) {
            a[i]=origin[i-1];
        }
        return a;
    }

    private void swap(int[] a,int index1,int index2){
        int t=a[index1];
        a[index1]=a[index2];
        a[index2]=t;
    }


    public int get(){
        return heap[1];
    }

    public int pop(){
        int value=heap[1];
        swap(heap,1,size);
        downBalance(1);
        size--;
        return value;
    }

    public void push(int value){
        if(heap==null)
            init(null);
        if(size>=heap.length-1)
            heap=Arrays.copyOf(heap,heap.length*2);

        heap[size+1]=value;
        upBalance(size+1);
        size++;
    }

    //自底向上调整
    private void upBalance(int index){
        int i=index;
        while (i > 0) {
            if(heap[i/2]>heap[i]){
                swap(heap,i,i/2);
            }
            i/=2;
        }
    }

    //自顶向下调整
    private void downBalance(int father){
        int left=2*father;
        int right=2*father+1;
        if(left>=size)
            return ;
        //left和right都小于数组长度
        if(left<size&&right<size){
            if(heap[left]<heap[right]){
                if(heap[left]<heap[father]) {
                    swap(heap, father, left);
                    downBalance(left);
                }
            }else{
                if(heap[right]<heap[father]) {
                    swap(heap,father, right);
                    downBalance(right);
                }
            }
        }else if(left<size){
            if(heap[left]<heap[father]) {
                swap(heap, father, left);
            }
        }
    }


    public int getSize() {
        return size;
    }

}
