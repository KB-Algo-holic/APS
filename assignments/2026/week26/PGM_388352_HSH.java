package week26;

public class PGM_388352_HSH {
    public static void main(String[] args) {
        int n = 5;
        int[][] q = { { 1, 2 }, { 1, 3 }, { 2, 4 }, { 2, 5 } };
        int[] ans = { 1, 2, 3, 4, 5 };

        PGM_388352_HSH solution = new PGM_388352_HSH();
        int result = solution.solution(n, q, ans);

        System.out.println(result);
    }

    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;

        // 각 쿼리에 대해 정답과 비교
        for (int i = 0; i < q.length; i++) {
            int start = q[i][0];
            int end = q[i][1];
            int expected = ans[i];

            // 구간 내의 모든 수를 더하여 정답과 비교
            int sum = 0;
            for (int j = start; j <= end; j++) {
                sum += j;
            }

            if (sum == expected) {
                answer++;
            }
        }

        return answer;
    }
}
