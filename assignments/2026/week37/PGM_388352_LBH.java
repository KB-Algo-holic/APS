// 비밀 코드 해독
// DFS, 조합
// https://school.programmers.co.kr/learn/courses/30/lessons/388352

import java.util.*;

class Solution {
    int answer = 0;
    
    void DFS(int n, int[][] q, int[] ans, int[] arr, int index, int last) {
        if(index == 5) {
            for(int i = 0; i < q.length; i++) {
                int count = 0;
                for(int j = 0; j < 5; j++) {
                    for(int k = 0; k < 5; k++) {
                        if(arr[j] == q[i][k]) {
                            count++;
                            break;
                        }
                    }
                }

                if(count != ans[i]) {
                    return;
                }
            }
            
            answer++;
            return;
        }
        
        for(int i = last; i <= n; i++){
            arr[index] = i;
            DFS(n, q, ans, arr, index + 1, i + 1);
        }
    }
    
    public int solution(int n, int[][] q, int[] ans) {
        
        DFS(n, q, ans, new int[]{0, 0, 0, 0, 0}, 0, 1);
        
        return answer;
    }
}
