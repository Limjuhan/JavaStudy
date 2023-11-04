import java.text.DecimalFormat;
import java.util.*;

public class Test6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        HashMap<Integer,String> name = new HashMap<>();//후보자목록

        int voteCnt = 0;//총투표수
        int ingVote = 0;//현재투표수
        int playerCnt= 0;//투표 참여인원
        String vip = "";//당선인


        //투표작업 입력
        while(true) {
            System.out.print("총 진행할 투표수를 입력해 주세요.");
            voteCnt = sc.nextInt();//총투표수
            sc.nextLine();
            //투표수 검증
            if(voteCnt <1 || voteCnt > 10000) {
                System.out.println("투표수는 1 ~ 10000사이의 값을 입력해야 합니다.");
                continue;
            }
            break;
        }
        while (true) {
            System.out.print("가상 선거를 진행할 후보자 인원을 입력해 주세요.");
            playerCnt = sc.nextInt();//투표 참여인원
            sc.nextLine();
            //후보자인원 검증
            if(playerCnt < 2 || playerCnt > 10) {
                System.out.println("후보자인원은 2~10명 입력해야 합니다..");
                continue;
            }
            break;
        }

        int [] vNumber = new int[playerCnt];//후보자들 투표수담을공간

        Loop1:
        while(true) {
            for (int i = 0; i < playerCnt; i++) {
                System.out.print(i + 1 + "번째 후보자이름을 입력해 주세요.");
                String s = sc.nextLine();//후보자이름
                name.put(i,s);
                int nameLength = s.getBytes().length;
                //후보자이름글자 제한
                if(nameLength > 30) {
                    System.out.println("후보자이름은 10미만 입력해야 합니다.");
                    continue Loop1;
                }
            }
            break;
        }


        //투표계산 시작
        for(int i = 0; i < voteCnt; i++) {
            int vote = random.nextInt(playerCnt);//어느후보자 투표할지 선택
            vNumber[vote]++;//투표자별 투표
            int ing = ++ingVote;//현재투표수
            double pVote = (double)ing / (double)voteCnt * 100.0f;//투표진행률

            //투표진행률
            System.out.printf("[투표진행률]: %.2f%%, %d명 투표 => %s\n", pVote,ing, name.get(vote));
            //후보자별 투표율
            for(int j=0;j<playerCnt;j++) {
                System.out.printf("[기호:%d] %s: %.2f%% (투표수: %d)\n",j+1, name.get(j),(double)vNumber[j]/(double)ing * 100.0f,vNumber[j]);
            }

            //당선자 출력
            int max = 0;
            if(i == voteCnt-1){
                for(int v = 0; v < vNumber.length; v++) {
                    if(max < vNumber[v]) {
                        max = vNumber[v];
                        vip = name.get(v);
                    }
                }
                System.out.println();
                System.out.println("[투표결과] 당선인 : " + vip);
            }
        }











    }
}
