import java.util.*;
class Solution {
    static int answer = 0;
    static int[] arr;
    public int solution(int n, int[][] q, int[] ans) {
        arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = i+1;
        makeAns(0, new ArrayList<>(), n, q, ans);
        return answer;
    }

    public void makeAns(int cur, List<Integer> list, int n, int[][] q, int[] ans) {
        if(list.size() == 5) {
            if(check(q, ans, list)) answer++;
            return;
        }

        for(int i=cur; i<n; i++) {
            list.add(arr[i]);
            makeAns(i+1, list, n, q, ans);
            list.remove(list.size() - 1);
        }
    }

    public boolean check(int[][] q, int[] ans, List<Integer> list) {
        for(int i=0; i<q.length; i++) {
            int cnt = 0;
            for(int j=0; j<q[i].length; j++) {
                for(int k=0; k<list.size(); k++) {
                    if(q[i][j] == list.get(k)){
                        cnt++;
                        break;
                    }
                }
            }

            if(cnt != ans[i]) return false;
        }
        return true;
    }
}