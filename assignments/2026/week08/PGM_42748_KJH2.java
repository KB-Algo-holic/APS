// PGM_42748 K번째 수
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/42748
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++){
            int[] tmp_arr = new int[commands[i][1] - commands[i][0] + 1];
            int idx = 0;
            for(int j = commands[i][0] - 1; j < commands[i][1]; j++){
               tmp_arr[idx++] = array[j];
            }
            answer[i] = sortAndSet(tmp_arr, commands[i][2]);
        }
        return answer;
    }
    
    public int sortAndSet(int[] tmp_arr, int n){
        for(int i = 0; i < tmp_arr.length - 1; i++){
            for(int j = i + 1; j < tmp_arr.length; j++){
                if(tmp_arr[i] > tmp_arr[j]){
                    int tmp = tmp_arr[i];
                    tmp_arr[i] = tmp_arr[j];
                    tmp_arr[j] = tmp;
                }
            }
        }
        return tmp_arr[n - 1];
    }
}