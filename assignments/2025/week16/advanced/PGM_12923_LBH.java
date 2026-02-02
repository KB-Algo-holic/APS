// PGM 12923 - 숫자 블록
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/12923

import java.util.*;

class Solution {

    int getBlock(int n) {
        if(n == 1) {
            return 0;
        }

        int div = 1;

        while(n > 1) {
            int oldN = n;
            for(int i = 2; i <= (int) Math.sqrt(n) + 1; i++) {
                if(n % i == 0) {
                    if(n / i <= 10000000) {
                        return n / i;
                    }
                }
            }

            for(int i = 2; i <= (int) Math.sqrt(n) + 1; i++) {
                if(n % i == 0) {
                    n /= i;
                    div *= i;
                    break;
                }
            }

            if(oldN == n) {
                break;
            }
        }

        return div;
    }

    public int[] solution(long begin, long end) {

        int iBegin = (int)begin;
        int iEnd = (int)end;

        int[] answer = new int[iEnd - iBegin + 1];

        for(int i = iBegin; i <= iEnd; i++) {
            answer[i - iBegin] = getBlock(i);
        }

        return answer;
    }
}