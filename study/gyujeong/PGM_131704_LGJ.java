// PGM 택배상자
// stack 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/131704#


import java.util.*;

public class PGM_131704_LGJ {
    public static int solution(int[] order) {
        int answer = 0;
        int n = order.length;
        int next = 1;//순서 상 다음
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<n; i++) {
            int cur = order[i];
            if (cur == next) {
                answer ++;
                next ++;
            } else if (cur > next) {
                for (int j=next; j<cur; j++) {
                    stack.push(j);
                }
                answer ++;
                next = cur+1;
            } else {
                if (stack.isEmpty() || stack.peek() != cur) break;
                answer ++;
                stack.pop();
            }


        }

        return answer;
    }

}
