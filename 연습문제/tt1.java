import java.util.HashMap;

public class tt1 {
        static HashMap<String,Integer> map = new HashMap<>();
    public static void solution(String s) {
        int result = 0;
        String[] s1 = s.split("");

        map.put("I",1);
        map.put("IV", 4);
        map.put("V",5);
        map.put("IX", 9);
        map.put("X",10);
        map.put("XL", 40);
        map.put("L",50);
        map.put("XC", 90);
        map.put("C",100);
        map.put("CD", 400);
        map.put("D",500);
        map.put("CM", 900);
        map.put("M",1000);


        for(int i = 0; i < s1.length; i++) {
           char tmp =  s1[i].charAt(0);
           if((tmp == 'I' || tmp == 'C' || tmp == 'X') && i < s1.length - 1) {
               String s2 = s1[i] + s1[i+1];
               if(map.containsKey(s2)) {
                   result += map.get(s2);
                   i++;
                   continue;
               }
           }
           result += map.get(s1[i]);
        }
        System.out.println("result = " + result);
    }

    private static String solution2(int num) {
        String result = "";

        String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

        int i = 0;
        while(num>0) {
            while(num>=values[i]) {
                num -= values[i];
                result += roman[i];
            }
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        solution("III");
        solution("IV");
        solution("VI");
        solution("XIII");
        solution("XXVI");
        solution("MCMXCIV");

        System.out.println(solution2(3));
        System.out.println(solution2(4));
        System.out.println(solution2(6));
        System.out.println(solution2(13));
        System.out.println(solution2(26));
        System.out.println(solution2(1994));


    }


}
