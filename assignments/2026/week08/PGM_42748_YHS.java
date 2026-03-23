import java.util.Arrays;

public class PGM_42748_YHS {
    public static int[] solution(int[] array, int[][] commands) {
        int size = commands.length;
        int[] answer = new int[size];
        for(int i=0; i<size; i++){
            int start = commands[i][0];
            int end   = commands[i][1];
            int idx   = commands[i][2];

            int[] arr = new int[end - start + 1];

            for(int j=0; j<arr.length; j++){
                arr[j] = array[j+start-1];
            }
            Arrays.sort(arr);
            answer[i] = arr[idx-1];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        solution(array, commands);
    }
}
