package Mission;

import java.util.Scanner;

public class Prac_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("내좌표 x값 입력");
        int x = sc.nextInt();
        System.out.println("내좌표 y값 입력");
        int y = sc.nextInt();

        int[][] compareD = new int[10][2];
        int[] dist = new int[10];


        for (int i = 0; i < 10; i++) {
            System.out.println(i+1 + "번째입력");
            System.out.println("x값 입력");
            int xx = sc.nextInt();
            System.out.println("y값 입력");
            int yy = sc.nextInt();

            for (int j = 0; j < i; j++) {
                if (xx == compareD[j][0] && yy == compareD[j][1]) {
                    System.out.println("동일좌표가 존재. 재입력 해주시기바랍니다.");
                    i--;
                }
            }

            compareD[i][0] = xx;
            compareD[i][1] = yy;
            dist[i] = Math.abs((x+y) - (xx+yy));
        }
        int min = Integer.MAX_VALUE;
        int num = 0;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] < min) {
                min = dist[i];
                num = i;
            }
        }
        System.out.println("나와 가장 가까운좌표값은 " + "(" +compareD[num][0]+","+compareD[num][1]+")");

    }
}
