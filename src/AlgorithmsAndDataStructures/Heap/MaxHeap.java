package AlgorithmsAndDataStructures.Heap;

import java.util.ArrayList;
import java.util.Arrays;

//基于动态数组实现的最大堆
public class MaxHeap<E extends Comparable<E>>{

    private ArrayList<E> data;

    public MaxHeap(){
        this.data = new ArrayList<>();
    }

    public MaxHeap(int capacity){
        data=new ArrayList<>(capacity);
    }

    //返回堆中的元素个数
    public int size(){
        return data.size();
    }

    //判断堆是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    //获取父亲节点的角标
    private int parent(int index){
        if(index==0){
            throw new IllegalArgumentException("无父节点");
        }
        return (index-1) / 2;
    }


    //获取左子节点角标
    private int leftChild(int index){
        return index*2 + 1;
    }

    //获取右子节点角标
    private int rightChild(int index){
        return index*2 + 2;
    }

    private void swap(int j, int k) {
       E temp =  data.get(j);
       data.set(j,data.get(k));
       data.set(k,temp);
    }

    //向堆中添加元素
    public void add(E e){
        data.add(e);
        siftUp(data.size() - 1);
    }

    private void siftUp(int w) {
        //w 不能是根节点，并且 w的值 要比 父节点的值 大
        while (w > 0 && data.get(parent(w)).compareTo(data.get(w)) < 0){
            swap(w,parent(w));
            w = parent(w);
        }
    }

    //查看堆中最大元素
    public E findMax(){
        if (data.size() == 0){
            throw new IllegalArgumentException(" can not find max value when heap is empty");
        }
        return data.get(0);
    }

    //取出堆中最大的元素
    public E extractMax(){
        E ret = findMax();
        swap(0,data.size() - 1);
        data.remove(data.size() - 1);
        siftDown(0);
        return  ret;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.size()){
            int j = leftChild(k);
            if (j + 1 <data.size() && data.get(j).compareTo(data.get(j+1)) < 0){
                j = rightChild(k);
            }
            if (data.get(k).compareTo(data.get(j)) >= 0){
                 break;
            }
            swap(k,j);
            k = j;
        }
    }

    //取出堆中最大的元素，替换为 元素e
    public E replace(E e){
        E ret = findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }

    //将数组转化为 堆
    public MaxHeap(E[] arr){ 
        data = new ArrayList<>(Arrays.asList(arr));
        for (int i = parent(data.size() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }
}
