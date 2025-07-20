// PGM 388352 - 비밀 코드 해독
// 유형: DFS/BFS
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/388352

import java.util.*;

class Solution {

    static int N, answer;
    static int[] numbers, input, ANS;
    static int[][] Q;
    static boolean[] checked;

    public int solution(int n, int[][] q, int[] ans) {
        N = n;
        Q = q;
        ANS = ans;

        checked = new boolean[n+1];
        numbers = new int[5]; //조합을 담을 배열
        input = new int[n+1]; //조합이 가능한 배열

        for(int i = 1; i <= n; i++){
            input[i] = i;
        }

        combi(0,1);

        return answer;

    }

    public static void combi(int cnt, int start){
        if(cnt == 5){
            for(int i = 0; i < Q.length; i++){
                int num = 0;

                //두 배열간 중복 값 비교
                HashSet<Integer> set = new HashSet<>();
                for(int number : numbers){
                    set.add(number);
                }
                for(int number : Q[i]){
                    if(set.contains(number))
                        num++;
                }
                //ans비교
                if(num != ANS[i])
                    return;
            }
            answer++;
            return;
        }

        //조합
        for(int i = start; i <= N; i++){
            numbers[cnt] = input[i];
            combi(cnt + 1, i + 1);
        }
    }

}