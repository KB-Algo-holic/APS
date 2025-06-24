import java.util.*;

class Solution {
    public int[] solution(int[] answers) {

        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};
        int[] p_answer = new int[3];

        for(int i = 0; i < answers.length; i++){
            if(answers[i] == p1[i%5]){
                p_answer[0]++;
            }
            if(answers[i] == p2[i%8]){
                p_answer[1]++;
            }
            if(answers[i] == p3[i%10]){
                p_answer[2]++;
            }
        }

        int max = p_answer[0];
        int max_p = 0;
        Queue<Integer> q = new LinkedList<Integer>();

        for(int i = 0; i < 3; i++){
            if(max == p_answer[i]){
                max_p++;
            }else if(max < p_answer[i]){
                max = p_answer[i];
            }
        }

        int[] answer = new int[max_p];

        for(int i = 0; i < 3; i++){
            if(p_answer[i] == max){
                q.offer(i+1);
            }
        }

        int cnt = q.size();

        for(int i = 0; i < cnt; i++){
            answer[i] = q.poll();
        }

        return answer;
    }
}