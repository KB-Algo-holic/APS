class Solution {
    public int solution(int n) {

        long n0 = 0;
        long n1 = 1;
        long answer = n0 + n1;

        for (int i=2; i<=n; i++) {
            answer = (n0 + n1) % 1234567;
            n0 = n1;
            n1 = answer;
        }

        return (int) answer;
    }
}