import java.util.*;

class Solution {

    static int N, answer;
    static int[] numbers, input, ANS;
    static int[][] Q;
    static boolean[] checked;

    public int solution(int n, int[][] q, int[] ans) {
        N = 7;
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
                System.out.println(Arrays.toString(numbers));
                int num = 0;

                //두 배열간 중복 제거
                HashSet<Integer> set = new HashSet<>();
                for(int number : numbers){
                    set.add(number);
                }
                for(int number : Q[i]){
                    if(set.contains(number))
                        num++;
                }
                //ANS 비교
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