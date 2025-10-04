// PGM 64061 - 크레인 인형뽑기 게임
// 큐, 스택
// https://school.programmers.co.kr/learn/courses/30/lessons/64061

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i = 0; i < moves.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[j][moves[i] - 1] > 0) {
                    if(dq.size() > 0) {
                        if(dq.peekLast() == board[j][moves[i] - 1]){
                            dq.pollLast();
                            answer += 2;
                        }
                        else {
                            dq.offerLast(board[j][moves[i] - 1]);
                        }
                    } else {
                        dq.offerLast(board[j][moves[i] - 1]);
                    }
                    
                    board[j][moves[i] - 1] = 0;
                    break;
                }
            }
        }
        
        return answer;
    }
}
