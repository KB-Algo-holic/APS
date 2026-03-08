// PGM - 12940
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/12940

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        // 최대공약수 구하기
        int gcd = 1;
        int min = Math.min(n, m);

        for (int i=min; i>0; i--) {
            if (n % i == 0 && m % i == 0) {
                gcd = i;
                break;
            }
        }
        answer[0] = gcd;
        // 최소공배수 = n * m / 최대공약수
        answer[1] = (n*m) / gcd;
        return answer;
    }
}