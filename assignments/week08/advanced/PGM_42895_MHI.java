import java.util.*;
public class Solution {
    TreeSet<Integer>[] dp;
    public int solution(int N, int number) {
        int answer = 0;

        dp = new TreeSet[10];

        for(int i =1 ; i<= 8; i++){
            solve(N, i);
            if (dp[i].contains(number)) return i;
        }
        return -1;
    }

    public TreeSet<Integer> solve(int N, int cnt) {
        if ((dp[cnt]!=null) && !dp[cnt].isEmpty()) return dp[cnt];

        TreeSet<Integer> temp = new TreeSet<>();

        int num = 0;
        for (int i = 0; i < cnt; i++) num = 10 * num + N;
        temp.add(num);

        for(int i =1; i<cnt; i++){

            TreeSet<Integer> from = solve(N, i);
            TreeSet<Integer> to = solve(N, cnt-i);

            for(int n1 : from) {
                for (int n2 : to) {
                    temp.add(n1 + n2);
                    temp.add(n1 - n2);
                    temp.add(n1 * n2);
                    if(n2 != 0) temp.add(n1 / n2);
                }
            }
        }
        return dp[cnt] = temp;
    }
}