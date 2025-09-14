// PGM 12940 - 최대공약수와 최소공배수
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/12940

import java.util.*;

class Solution {

    int getGCD(int n, int m){
        for(int i = (n < m ? n : m); i > 0; i--){
            if(n % i == 0 && m % i == 0){
                return i;
            }
        }

        return 0;
    }

    int getLCM(int n, int m){
        for(int i = 1; i < Integer.MAX_VALUE; i++){
            int LCM = (n < m ? m : n) * i;
            if(LCM % n == 0 && LCM % m == 0){
                return LCM;
            }
        }

        return 0;
    }

    public int[] solution(int n, int m) {
        return new int[]{getGCD(n, m), getLCM(n, m)};
    }
}