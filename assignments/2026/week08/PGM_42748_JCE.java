import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int n = 0; n < commands.length; n++) {
            int i = commands[n][0];
            int j = commands[n][1];
            int k = commands[n][2];

            // array에서 i번째부터 j번째 까지 자르기
            int len = j - i + 1;
            /*int[] cutArr = new int[len];
            for (int l = 0; l < len; l++) {
                cutArr[l] = array[i + l - 1];
            }*/
            // copyOfRange 사용
            int[] cutArr = Arrays.copyOfRange(array, i - 1, j);
            // 정렬
            Arrays.sort(cutArr);
            
            answer[n] = cutArr[k - 1];

        }
        return answer;
    }
}
