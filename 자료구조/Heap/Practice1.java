package Heap;// Practice 1
// ArrayList 로 최대 힙 구현

import java.util.ArrayList;

class Maxheap {
    ArrayList<Integer> heap;

    public Maxheap() {
        this.heap = new ArrayList<>();
        this.heap.add(0);
    }

    public void insert(int data) {
        heap.add(data);

        int cur = heap.size() - 1;
        while (cur > 1 && heap.get(cur / 2) < heap.get(cur)) {
            int parentVal = heap.get(cur / 2);
            heap.set(cur / 2, data);
            heap.set(cur, parentVal);

            cur /= 2;
        }
    }

    public Integer delete() {//가장위에있는 값을 삭제하는게 힙구조. 값을 받을필요없다.
        if (heap.size() == 1) {
            System.out.println("Heap is empty!");
            return null;
        }

        int target = heap.get(1);//Heap기준 가장 최상위노드. heap.get(0)은 더미데이터

        heap.set(1, heap.get(heap.size() - 1));//마지막데이터를 루트에다가 저장
        heap.remove(heap.size() - 1);//가장위로 옮긴 마지막데이터 삭제


        //데이터 수정후 위아래 노드구성이 최소힙에 맞도록 재구성.
        int cur = 1;
        while (true) {
            int leftIdx = cur * 2;
            int rightIdx = cur * 2 + 1;
            int targetIdx = -1;

            if (rightIdx < heap.size()) {//자식노드가 2개인경우
                targetIdx = heap.get(leftIdx) > heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if (leftIdx < heap.size()) {//자식노드가 1개인경우
                targetIdx = cur * 2;//leftIdx
            } else {//부모노드밖에없거나 leaf노드인 경우
                break;
            }

            if (heap.get(cur) > heap.get(targetIdx)) {
                break;
            } else {
                int parentVal = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parentVal);
                cur = targetIdx;
            }
        }
        return target;
    }

    public void printTree() {
        for (int i = 1; i < this.heap.size(); i++) {
            System.out.print(this.heap.get(i) + " ");
        }
        System.out.println();
    }
}

public class Practice1 {
    public static void main(String[] args) {
        // Test code
//        MaxHeap maxHeap = new MaxHeap();
//        System.out.println("== 데이터 삽입 ==");
//        maxHeap.insert(30);
//        maxHeap.insert(40);
//        maxHeap.insert(10);
//        maxHeap.printTree();
//        maxHeap.insert(50);
//        maxHeap.insert(60);
//        maxHeap.insert(70);
//        maxHeap.printTree();
//        maxHeap.insert(20);
//        maxHeap.printTree();
//        maxHeap.insert(30);
//        maxHeap.printTree();
//
//        System.out.println();
//        System.out.println("== 데이터 삭제 ==");
//        System.out.println("삭제: " + maxHeap.delete());
//        maxHeap.printTree();
//        System.out.println("삭제: " + maxHeap.delete());
//        maxHeap.printTree();
//        System.out.println("삭제: " + maxHeap.delete());
//        maxHeap.printTree();
    }
}
