package week07;

public class PGM_181832_HSH {

    public static void main(String[] args) {
        PGM_181832_HSH sol = new PGM_181832_HSH();

        int[][] result = sol.solution(4);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] solution(int n) {
        int[][] answer = {};
        int M = n;
        int N = n;
        answer = new int[M][N];
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int number = 1;
        while (number <= M * N) {
            // 왼쪽에서 오른쪽으로 이동해 채우기
            for (int i = left; i <= right; i++) {
                answer[top][i] = number++; // 값을 넣고 index값 올리기
            }
            top += 1;
            // 위에서 아래로 내리기
            for (int i = top; i <= bottom; i++) {
                answer[i][right] = number++;
            }
            right -= 1;
            // 오른쪽에서 왼쪽으로 이동
            for (int i = right; i >= left; i--) {
                answer[bottom][i] = number++;
            }
            bottom -= 1;
            // bottom -> top
            for (int i = bottom; i >= top; i--) {
                answer[i][left] = number++;
            }
            left += 1;
        }

        return answer;
    }
}
