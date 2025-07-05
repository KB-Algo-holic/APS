// PGM 43162 - 네트워크
// 유형: DFS/BFS
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43162

import java.util.*;

class Solution {

    static int[] chk;
    static int answer;
    static boolean cntChk;

    public int solution(int n, int[][] computers) {
        int cnt = 1;
        chk = new int[n];
        for(int i = 0; i < n; i++){
            if(cntChk){
                cntChk = false;
                cnt++;
            }
            move(computers, computers[i], n, cnt);
        }

        Arrays.sort(chk);

        return chk[n-1];
    }

    public static void move(int[][] computers, int[] computer, int n, int cnt){
        for(int i = 0; i < n; i++){
            if(computer[i] == 1 && chk[i] == 0){
                chk[i] = cnt;
                cntChk = true;
                move(computers, computers[i], n , cnt);
            }
        }
    }
}