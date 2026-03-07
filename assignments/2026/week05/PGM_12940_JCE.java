/* 유클리드 호제법 : 최대 공약수 빠르게 구하기(큰 수를 작은 수로 나눈 나머지로 계속 반복) */
class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        // 1. 최대공약수 구하기 (유클리드 호제법 참고)
        if (n > m) answer[0] = gcd(n, m);
        else answer[0] = gcd(m, n);
        // 2. 최소공배수 구하기 (두 수를 곱해서 최대공약수로 나누기)
        answer[1] = n * m / answer[0];
        
        return answer;
    }
    
    private int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
}
