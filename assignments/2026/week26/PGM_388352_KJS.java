// PGM 49993 - 비밀 코드 해독
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/388352?language=java

import java.util.*;
class Solution {
    static int answer = 0;
    static int[] arr;
    public int solution(int n, int[][] q, int[] ans) {        
        arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = i+1;
        comb(n, q, ans, 0, new ArrayList<>());
        return answer;
    }
    
    public void comb(int n, int[][] q, int[] ans, int cur, List<Integer> list) {
        if(list.size() == 5) {
            // System.out.println(list);
            if(isPossible(q, ans, list)) answer++;
            return;
        }
        
        for(int i=cur; i<n; i++) {
            list.add(arr[i]);
            comb(n, q, ans, i+1, list);
            list.remove(list.size() - 1);
        }
    }
    
    public boolean isPossible(int[][] q, int[] ans, List<Integer> list) {
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
