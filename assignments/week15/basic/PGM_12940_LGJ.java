class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = Math.min(n, m); i >= 1; i--) {
            if (n % i == 0 && m % i == 0) {
                answer[0] = i;
                break;
            }
        }

        for (int i=Math.max(n, m); i<=n*m; i++) {
            if (i % n == 0 && i % m == 0) {
                answer[1] = i;
                break;
            }
        }


        return answer;
    }
}