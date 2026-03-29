import java.util.Arrays;

public class PGM_42748_HSH {

    public static void main(String[] args) {
        int[] input = { 1, 5, 2, 6, 3, 7, 4 };
        int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

        int result[] = solution(input, commands);
        for (int elem : result) {
            System.out.print(elem + " ");
        }
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        // 2차원 배열에 들어간 값에서 i, j, k 순으로 진행
        int inx = 0;
        for (int index = 0; index < commands.length; index++) {
            int i = commands[index][0];
            int j = commands[index][1];
            int k = commands[index][2];
            // array의 i~j를 구해서 잘라서 배열을 만드는데, copyOfRange를 쓰면 범위로 지정해서 복사하는 로직
            // 복사한 배열을 오름차순으로 정리한 후에 다른 배열에 넣으면서 k번째 값을 반환한다.
            int cpArray[] = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(cpArray);
            answer[inx++] = cpArray[k - 1];
        }
        return answer;
    }
}
