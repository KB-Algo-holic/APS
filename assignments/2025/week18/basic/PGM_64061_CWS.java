// PGM 64061 - 크레인 인형뽑기 게임
// 유형: 큐/스택
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/64061

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
임
        for(int i = 0; i < moves.length; i++){

            for(int j = 0; j < board.length; j++){

                if(board[j][moves[i]-1] != 0){
                    // 비어있지 않고, 같으면
                    if(!dq.isEmpty() && dq.peekLast() == board[j][moves[i]-1]){
                        dq.pollLast();  // 맨위에서 하나빼기
                        answer += 2;   // 2개씩 터지기때문에 +2
                    }else{
                        dq.offerLast(board[j][moves[i]-1]);
                    }
                    board[j][moves[i]-1] = 0; // 비우기
                    break;
                }
            }
        }

        return answer;
    }
}