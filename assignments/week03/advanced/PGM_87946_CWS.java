import java.util.*;

class Solution {

    static int answer = 0;

    public int solution(int k, int[][] dungeons) {
        for(int i = 0; i < dungeons.length; i++){
            int cnt = 0;
            int nowK = k;
            boolean[] dungeonsChk = new boolean[dungeons.length];
            dungeonsChk[i] = true;

            if(nowK >= dungeons[i][0]){
                nowK -= dungeons[i][1];
                move(dungeonsChk, nowK, cnt+1, dungeons);
            }
        }
        return answer + 1;

    }
    static void move(boolean[] dungeonsChk, int nowK, int cnt, int[][] dungeons){
        for(int i = 0; i < dungeons.length; i++){
            if(!dungeonsChk[i] && nowK >= dungeons[i][0]){
                dungeonsChk[i] = true;
                answer = Math.max(answer, cnt);
                move(dungeonsChk, nowK - dungeons[i][1], cnt+1, dungeons);
                dungeonsChk[i] = false;

            }
        }
    }


}