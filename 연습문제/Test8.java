//임주한

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Test8 {
    static HashMap<Integer, ArrayList<Long>> map = new HashMap<>();
    static int[] taxRate = {6,15,24,35,38,40,42,45};//세율
    static long m1 = 12000000;
    static long m2 = 46000000;
    static long m3 = 88000000;
    static long m4 = 150000000;
    static long m5 = 300000000;
    static long m6 = 500000000;
    static long m7 = 1000000000;


    public static void main(String[] args) {

        long t1 = m1;//과세표준.6%
        long t2 = m2 - m1;//3400만원.15%
        long t3 = m3 - m2;//4200만원.24%
        long t4 = m4 - m3;//6200만원.35%
        long t5 = m5 - m4;//15000만원.38%
        long t6 = m6 - m5;//20000만원.40%
        long t7 = m7 - m6;//50000만원.42%
        long t8 = m7;//45%


        long[][] arr = {
                {t1,0},
                {t2,1080000},
                {t3,5220000},
                {t4,14900000},
                {t5,19400000},
                {t6,25400000},
                {t7,35400000},
                {t8,65400000},
        };

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 1; j++) {
                map.put(taxRate[i],new ArrayList<>(Arrays.asList(arr[i][j],arr[i][j+1])));
            }
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요.:");
        long income = sc.nextLong();
        sc.nextLine();
        sc.close();

        taxCalculate(income);

    }

    static void taxCalculate(long income) {
        long sumTax = 0;
        long progressive = 0;

        if(income > m7) {
            //세금계산
            for (int i = 0; i < 7; i++) {
                sumTax += map.get(taxRate[i]).get(0) * taxRate[i] / 100;
                System.out.printf("%10d * %2d%% = %10d\n",map.get(taxRate[i]).get(0),taxRate[i], map.get(taxRate[i]).get(0) * taxRate[i] / 100);
            }
            System.out.printf("%10d * %2d%% = %10d\n",(income - m7),taxRate[7], (income - m7) * taxRate[7] / 100);

            sumTax += (income - m7) * taxRate[7] / 100;//세금
            progressive = (income * taxRate[7] / 100) - map.get(taxRate[7]).get(1);//누진공제금액


        } else if (income > m6) {
            for (int i = 0; i < 6; i++) {
                sumTax += map.get(taxRate[i]).get(0) * taxRate[i] / 100;
                System.out.printf("%10d * %2d%% = %10d\n",map.get(taxRate[i]).get(0),taxRate[i], map.get(taxRate[i]).get(0) * taxRate[i] / 100);
            }
            System.out.printf("%10d * %2d%% = %10d\n",(income - m6),taxRate[6], (income - m6) * taxRate[6] / 100);

            sumTax += (income - m6) * taxRate[6] / 100;
            progressive = (income * taxRate[6] / 100) - map.get(taxRate[6]).get(1);

        } else if (income > m5) {
            for (int i = 0; i < 5; i++) {
                sumTax += map.get(taxRate[i]).get(0) * taxRate[i] / 100;
                System.out.printf("%10d * %2d%% = %10d\n",map.get(taxRate[i]).get(0),taxRate[i], map.get(taxRate[i]).get(0) * taxRate[i] / 100);
            }
            System.out.printf("%10d * %2d%% = %10d\n",(income - m5),taxRate[5], (income - m5) * taxRate[5] / 100);

            sumTax += (income - m5) * taxRate[5] / 100;
            progressive = (income * taxRate[5] / 100) - map.get(taxRate[5]).get(1);

        } else if (income > m4) {
            for (int i = 0; i < 4; i++) {
                sumTax += map.get(taxRate[i]).get(0) * taxRate[i] / 100;
                System.out.printf("%10d * %2d%% = %10d\n",map.get(taxRate[i]).get(0),taxRate[i], map.get(taxRate[i]).get(0) * taxRate[i] / 100);
            }
            System.out.printf("%10d * %2d%% = %10d\n",(income - m4),taxRate[4], (income - m4) * taxRate[4] / 100);

            sumTax += (income - m4) * taxRate[4] / 100;
            progressive = (income * taxRate[4] / 100) - map.get(taxRate[4]).get(1);

        } else if (income > m3) {
            for (int i = 0; i < 3; i++) {
                sumTax += map.get(taxRate[i]).get(0) * taxRate[i] / 100;
                System.out.printf("%10d * %2d%% = %10d\n",map.get(taxRate[i]).get(0),taxRate[i], map.get(taxRate[i]).get(0) * taxRate[i] / 100);
            }
            System.out.printf("%10d * %2d%% = %10d\n",(income - m3),taxRate[3], (income - m3) * taxRate[3] / 100);

            sumTax += (income - m3) * taxRate[3] / 100;
            progressive = (income * taxRate[3] / 100) - map.get(taxRate[3]).get(1);

        } else if (income > m2) {
            for (int i = 0; i < 2; i++) {
                sumTax += map.get(taxRate[i]).get(0) * taxRate[i] / 100;
                System.out.printf("%10d * %2d%% = %10d\n",map.get(taxRate[i]).get(0),taxRate[i], map.get(taxRate[i]).get(0) * taxRate[i] / 100);
            }
            System.out.printf("%10d * %2d%% = %10d\n",(income - m2),taxRate[2], (income - m2) * taxRate[2] / 100);

            sumTax += (income - m2) * taxRate[2] / 100;
            progressive = (income * taxRate[2] / 100) - map.get(taxRate[2]).get(1);

        } else if (income > m1) {
            for (int i = 0; i < 1; i++) {
                sumTax += map.get(taxRate[i]).get(0) * taxRate[i] / 100;
                System.out.printf("%10d * %2d%% = %10d\n",map.get(taxRate[i]).get(0),taxRate[i], map.get(taxRate[i]).get(0) * taxRate[i] / 100);
            }
            System.out.printf("%10d * %2d%% = %10d\n",(income - m1),taxRate[1], (income - m1) * taxRate[1] / 100);

            sumTax += (income - m1) * taxRate[1] / 100;
            progressive = (income * taxRate[1] / 100) - map.get(taxRate[1]).get(1);

        } else {
            System.out.printf("%10d * %2d%% = %10d\n", income, taxRate[0], income* taxRate[0] / 100);
            sumTax = income * taxRate[0] / 100;
            progressive = sumTax;
        }

        System.out.printf("[셰율에 의한 세금]:\t\t\t\t%10d\n",sumTax);
        System.out.printf("[누진공제 계산에 의한 세금]:\t\t%10d",progressive);

    }
}


