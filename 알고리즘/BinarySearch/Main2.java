package Algorithm.BinarySearch;
// 자바 기본 binarySearch

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};

        System.out.println("데이터가 있는 경우");
        System.out.println(Arrays.binarySearch(arr, 1));
        System.out.println(Arrays.binarySearch(arr, 10));
        System.out.println(Arrays.binarySearch(arr, 30));

        System.out.println("데이터가 없는 경우");
        //존재한다면 위치해있어야할 인덱스 를 -로 바꾼후 -1한값이 출력
        //원래 위치인덱스를 찾으려면 부호 변경우 -1 처리
        System.out.println(Arrays.binarySearch(arr, 3));//-3
        System.out.println(Arrays.binarySearch(arr, 11));//-5
        System.out.println(Arrays.binarySearch(arr, 35));//-7
    }
}
