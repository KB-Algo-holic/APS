// PGM 12936 - 줄 서는 방법
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/12936

import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        boolean[] used = new boolean[n + 1];

        int[] answer = new int[n];

        for(int i = n; i >= 1; i--) {
            long iFact = 1;
            for(int j = 1; j < i; j++) {
                iFact *= j;
            }
            for(int j = 0; j < n; j++) {
                if(iFact * j <= k && k <= iFact * (j + 1)) {
                    k -= iFact * j;
                    int time = 0;
                    for(int u = 1; u <= n; u++) {
                        if(!used[u]) {
                            if(time == j) {
                                answer[Math.abs(i - n)] = u;
                                used[u] = true;
                                break;
                            }
                            time++;
                        }
                    }
                    break;
                }
            }
        }

        return answer;
    }
}
