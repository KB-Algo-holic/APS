// PGM - 388352 비밀코드해독
// 완전탐색 (조합)
// https://school.programmers.co.kr/learn/courses/30/lessons/388352?language=java


import java.util.*;

class Solution {
    int answer = 0;

    public int solution(int n, int[][] q, int[] ans) {

        comb(1, n, new ArrayList<Integer>(), q, ans);
        return answer;
    }

    void comb(int start, int n, List<Integer> cur, int[][] q, int[] ans) {

        if (cur.size() == 5) {
            //System.out.println(cur);
            if (validate(cur, q, ans)) {
                //System.out.println(cur);
                answer ++;
            }
            return;
        }

        for (int i=start; i<=n; i++) {
            cur.add(i);
            comb(i+1, n, cur, q, ans);
            cur.remove(cur.size()-1);
        }
    }

    boolean validate(List<Integer> password, int[][] query, int[] ans) {

        for (int i=0; i<ans.length; i++) {
            int correct = ans[i];
            int cnt = 0;
            int[] q = query[i];

            for (int num: q) {if (password.contains(num)) cnt ++;}

            if (cnt != correct) return false;

        }
        return true;
    }
}