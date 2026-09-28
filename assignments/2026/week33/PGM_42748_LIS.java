// PGM 42748 - K번째수
// 학습
// https://school.programmers.co.kr/learn/courses/30/lessons/42748?language=java
public class Solution {

    public int[] solution(int[] array, int[][] commands) {
        int answerSize = commands.length;
        int[] answer = new int[answerSize];

        for(int i=0; i<answerSize; i++){
            int size = commands[i][1] - commands[i][0] + 1;
            int start = commands[i][0] - 1;
            int[] temp = new int[size];

            for(int j=0; j<size; j++) {
                temp[j] = array[start];
                start++;
            }

            for(int k=0; k<temp.length; k++) {
                for(int l=0; l<temp.length-1; l++) {
                    if(temp[l] > temp[l+1]) {
                        int swap = temp[l];
                        temp[l] = temp[l+1];
                        temp[l+1] = swap;
                    }
                }   
            }

            int answerPart = temp[commands[i][2] - 1];
            answer[i] = answerPart;
        }

        return answer;
    }

}
