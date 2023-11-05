//임주한
//로또

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test7 {
    static Random random = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> result = new ArrayList<>();//생성된번호 담기
        ArrayList<String> winResult = new ArrayList<>();//당첨번호 담기

        System.out.println("[로또 당첨 프로그램]");
        //개수구매입력
        System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10):");
        int buyCnt = sc.nextInt();
        int buyCntChar = buyCnt+ 65;//구매 개수
        sc.nextLine();
        sc.close();

        //로또번호생성 및 출력
        for (int i = 0; i < buyCnt; i++) {
            result.add(createlotto());
        }

        int v = 0;
        String[] tt = new String[buyCnt];//생성번호출력문장 담기
        for(char i = 65; i < buyCntChar; i++) {
            tt[v] = i + "   " + result.get(v);
            System.out.println(i + "   " + result.get(v));
            v++;
        }

        //당첨번호 생성 및 출력
        System.out.println("[로또 발표]");
        winResult.add(winning());
        System.out.println("    " + winResult.get(0));

        //번호 비교 및 결과 출력
        System.out.println("[내 로또 결과]");
        String[] winNumbers = winResult.get(0).split(" ");//당첨번호 추출

        int correct = 0;//일치하는개수 카운트
        for(int i = 0; i < result.size(); i++) {
            String[] createNumbers = result.get(i).split(" ");
            correct = 0;
            for(int j = 0; j < 6; j++) {
                for(int k = 0; k < 6; k++) {
                    int rr = winNumbers[j].compareTo(createNumbers[k]);
                    if (rr == 0) {
                        correct++;
                    }
                }
            }
            System.out.println(tt[i] + " => " + correct + "개 일치");
        }


    }
    //로또번호 만들기
    static String createlotto() {
        int[] number = new int[6];
        String lotto = "";

        for(int i = 0; i < number.length; i++) {
            number[i] = random.nextInt(45) + 1;
            for(int j = 0; j < i; j++) {
                if(number[i] == number[j]) {
                    i--;
                }
            }
        }
        Arrays.sort(number);

        for(int i = 0; i < number.length; i++) {
            lotto += Integer.toString(number[i]) + " ";
        }

        return lotto;
    }

    //당첨번호 생성
    static String  winning() {
        int[] winNumber = new int[6];
        String winLotto = "";

        for(int i = 0; i < winNumber.length; i++) {
            winNumber[i] = random.nextInt(45) + 1;
            for(int j = 0; j < i; j++) {
                if(winNumber[i] == winNumber[j]) {
                    i--;
                }
            }
        }

        Arrays.sort(winNumber);

        for(int i = 0; i < winNumber.length; i++) {
            winLotto += Integer.toString(winNumber[i]) + " ";
        }

        return winLotto;
    }
}
