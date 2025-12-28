import java.util.*;

class Solution {
    public long solution(long w, long h) {

        // 전체 사각형 개수
        long answer = w * h;
        // w와 h의 최대공약수
        long gcd = GCD(w, h);
        // w/gcd, h/gcd : 서로소 직사각형의 가로/세로, -1 : 겹치는 꼭짓점 보정
        answer = answer - ((w / gcd) + (h / gcd) - 1) * gcd;
        // 멀쩡한 사각형 개수 반환
        return answer;
    }

    //  최대공약수 계산
    private long GCD(long w, long h){
        long A = Math.max(w, h);
        long B = Math.min(w, h);

        while(B > 0){
            long temp = B;
            B = A % B;
            A = temp;
        }
        return A;
    }
}
