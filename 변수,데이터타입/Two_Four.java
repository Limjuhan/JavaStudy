// Java 프로그래밍 - 변수와 자료형_4

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Two_Four {
    public static void main(String[] args) {

//      1. 자료형 - 리스트
        System.out.println("== 리스트 ==");
        ArrayList li = new ArrayList();

//      1-1. add
        li.add(1);
        li.add("Hello");
        li.add(2);
        li.add(3);
        li.add("world!");
        System.out.println("li= " + li);

        li.add(0,1);
        System.out.println("li= " + li);
//      1-2. get
        System.out.println(li.get(0));
        System.out.println(li.get(3));

//      1-3. size
        System.out.println(li.size());


//      1-4. remove
        System.out.println(li.remove(Integer.valueOf(2)));


//      1-5. clear
        li.clear();
        System.out.println(li);
//      1-6. sort
        ArrayList l2 = new ArrayList();
        l2.add(5);
        l2.add(3);
        l2.add(6);
        System.out.println(l2);

        l2.sort(Comparator.naturalOrder());//오름차순
        System.out.println(l2);
        l2.sort(Comparator.reverseOrder());//내림차순
        System.out.println(l2);

//      1-7. contains
        System.out.println(l2.contains(1));
        System.out.println(l2.contains(3));//값의 존재유무확인. true,false 반환


//      2. Maps
        System.out.println("== Maps ==");

        HashMap map = new HashMap();

//      2-1. put
        map.put("kiwi", 10000);
        map.put("apple", 310000);
        map.put("orange", 8000);

        System.out.println(map);//넣은 순서대로 출력 X
//      2-2. get
        System.out.println(map.get("mandarine"));//null
        System.out.println(map.get("orange"));//value값 출력

//      2-3. size
        System.out.println(map.size());//3

//      2-4. remove
        System.out.println(map.remove("orange"));//value출력
        System.out.println(map.remove("asdf"));//null
        System.out.println(map);

//      2-5. containsKey
        System.out.println(map.containsKey("apple"));//true
        System.out.println(map.containsKey("sdkfjsal"));//없는값은 false


//      3. Generics
        System.out.println("== Generics ==");
        ArrayList l3 = new ArrayList();
        l3.add(1);
        l3.add("hala");
        System.out.println("l3 = " + l3);

        ArrayList<String> l4 = new ArrayList<>();
        l4.add("Madrid");
        //l4.add(3);숫자는 입력 불가
        System.out.println("l4 = " + l4);

        HashMap map1 = new HashMap();
        map1.put(444,"ozil");

        HashMap<String,Integer> map2 = new HashMap<>();
        //map2.put(233,"Zizou"); 불가
        map2.put("djfkdf",32423);
    }

}
