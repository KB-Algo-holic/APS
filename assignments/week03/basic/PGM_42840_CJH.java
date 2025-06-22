// PGM 42840 - 수포자
// 유형 : 완전탐색
// 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42840

public class Solution {
    public int[] solution(int[] answers) {
        int[] man1Dap = {1, 2, 3, 4, 5};
        int[] man2Dap = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] man3Dap = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int true1 = 0;
        int true2 = 0;
        int true3 = 0;
        
        for (int i=0; i < answers.length; i++) {
            if (man1Dap[i%man1Dap.length] == answers[i]) true1++;
            if (man2Dap[i%man2Dap.length] == answers[i]) true2++;
            if (man3Dap[i%man3Dap.length] == answers[i]) true3++;
        }
        
        int[] answer = new int[3];
        
        if (true1 >= true2) {
            if (true1 >= true3) {
                answer[0] = 1;
                answer[1] = 2;
                answer[2] = 3;
            } else {
                answer[0] = 3;
                answer[1] = 1;
                answer[2] = 2;
            }
        } else if (true2 >= true3) {
            answer[0] = 2;
            if (true1 >= true3) {
                answer[1] = 1;
                answer[2] = 3;
            } else {
                answer[1] = 3;
                answer[2] = 1;
            }
            
        } else {
            answer[0] = 3;
            if (true1 >= true2) {
                answer[1] = 1;
                answer[2] = 2;
            } else {
                answer[1] = 2;
                answer[2] = 1;
            }
        }
        
        int len = 0;
        if (true1 == true2) {
            if (true2 == true3) {
                len = 3;
            } else  {
                len = 2;
            }
        } else {
            len = 1;
        }
        
        int[] finalAnswer = new int[len];
        if (len == 3) {
            finalAnswer[0] = answer[0];
            finalAnswer[1] = answer[1];
            finalAnswer[2] = answer[2];
        } else if (len == 2) {
            finalAnswer[0] = answer[0];
            finalAnswer[1] = answer[1];
            
        } else {
            finalAnswer[0] = answer[0];
        }
        
        return finalAnswer;
    }
    
    
    
    public static void main(String[] args) {
        
        
        int[] q = {1,3,2,4,2};
        
        new Solution().solution(q);
        ;
        
    }