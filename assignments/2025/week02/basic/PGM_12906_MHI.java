import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> st = new Stack<>();

        for (int num : arr) {
            if (st.isEmpty() || st.peek() != num) {
                st.push(num);
            }
        }

        int[] answer = new int[st.size()];
        int i = st.size() - 1;

        while (!st.isEmpty()) {
            answer[i] = st.pop();
            i--;
        }

        return answer;
    }
}