import java.util.*;
class Solution {
    static boolean [] check;
    public int[] solution(long begin, long end) {

        int s = (int) begin;
        int e = (int) end;

        int [] answer = new int [e - s + 1];
        Arrays.fill(answer, 1);

        for(int i = s; i <= e; i++) answer[i - s] = makeAns(i);
        if(s == 1) answer[0] = 0;

        return answer;
    }

    public static int makeAns(int input){
        int num = 1;

        for(int i = 2; i*i <= input; i++){
            if(input % i == 0){
                num = i;
                if(input / i <= 10000000) return input / i;
            }
        }

        return num;
    }
}