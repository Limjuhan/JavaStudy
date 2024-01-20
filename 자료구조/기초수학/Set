package Set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class MySet {

    //ArrayList
    ArrayList<Integer> list;
    HashMap<String, Integer> map;
    // 생성자1
    MySet() {
        this.list = new ArrayList<>();
    }

    //생성자2
    MySet(int[] arr) {
        this.list = new ArrayList<Integer>();

        for (int item: arr) {
            this.list.add(item);
        }
    }

// 원소 추가(중복X)
    public void add(int x) {
        for (int item: this.list) {
            if (item == x) {
                return;
            }
        }
        this.list.add(x);
    }

// 교집합.
    public MySet retainAll(MySet b) {
        MySet result = new MySet();

        for (int itemA: this.list) {
            for (int itemB: b.list) {
                if (itemA == itemB) {
                    result.add(itemA);
                }
            }
        }
        return result;
    }

// 합집합
    public MySet addAll(MySet b) {
        MySet result = new MySet();

        for (int itemA: this.list) {
            result.add(itemA);
        }
        for (int itemB: b.list) {
            result.add(itemB);
        }
        return result;
    }

// 차집합
    public MySet removeAll(MySet b) {
        MySet result = new MySet();

        for (int itemA: this.list) {
            boolean containFlag = false;

            for (int itemB: b.list) {
                if (itemA == itemB) {
                    containFlag = true;
                    break;
                }
            }

            if (!containFlag) {// 2개의 리스트가 중복되는값이 없을경우
                result.add(itemA);
            }
        }

        return result;
    }



}

public class Practice {
    public static void main(String[] args) {
        MySet a = new MySet();

        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);
        System.out.println("a.list = " + a.list);





    }
}
