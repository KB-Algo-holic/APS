class Solution {
    public int[] solution(int n, int m) {
        int minN = Math.min(n, m);

        int num = 1;
        for (int i=2; i<=minN; i++) {
            if (n%i == 0 && m%i == 0) {
                num = i;
            }
        }

        int[] answer = {num, (n/num) * (m/num) * num};
        return answer;
    }
}