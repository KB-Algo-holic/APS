// PGM 42584 주식가격
// 스택
// https://school.programmers.co.kr/learn/courses/30/lessons/42584



import java.util.*;

class Solution {
    public int[] solution(int[] prices) {

        int n = prices.length;
        int[] answer = new int[n];

        Stack<int[]> stack = new Stack<>();

        for (int i=0; i<n; i++) {
            int price = prices[i];
            while (!stack.isEmpty() && stack.peek()[1] > price) {
                int[] top = stack.pop();
                answer[top[0]] = i-top[0];
            }
            stack.push(new int[] {i, price});

        }
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            answer[top[0]] = n-top[0]-1;
        }




        return answer;
    }
}