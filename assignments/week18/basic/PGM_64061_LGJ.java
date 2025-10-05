// PGM 크레인 인형뽑기
// 구현 - 스택
// https://school.programmers.co.kr/learn/courses/30/lessons/64061

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int m = board.length;
        Stack<Integer> basket = new Stack<Integer>();
        List<Stack<Integer>> boards = new ArrayList<>();
        for (int i=0; i<m; i++) {
            Stack<Integer> temp = new Stack<>();
            boards.add(temp);
        }

        for (int i=m-1; i>=0; i--) {
            // 뒤가 0번째줄
            for (int j=0; j<m; j++) {
                int ch = board[i][j];
                if (ch == 0) continue;
                boards.get(j).push(ch);
            }

        }

        //System.out.println(boards);

        for (int c: moves) {
            //System.out.println("c :" + Integer.toString(c-1));
            //System.out.println(boards);
            Stack<Integer> temp = boards.get(c-1);
            if (temp.isEmpty()) continue;
            int cur = temp.pop();

            if (!basket.isEmpty() && cur == basket.peek()) {
                basket.pop();
                answer += 2;
            }
            else basket.push(cur);
            //System.out.println(basket);
        }


        return answer;
    }
}