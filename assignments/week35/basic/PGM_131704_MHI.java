import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        int num = 1;
        for (int i : order) {
            while (num <= order.length && (num != i && (st.isEmpty() || st.peek() != i))) {
                st.push(num++);
            }
            if (num == i) {
                num ++;
                answer ++;
            } else if (st.peek() == i) {
                st.pop();
                answer ++;
            } else if (num >= order.length) {
                break;
            }
        }
        return answer;
    }
}