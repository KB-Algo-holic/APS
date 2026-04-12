package week09;

import java.util.Stack;

public class PGM_133502_HSH {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int ing[] = {
                2, 1, 1, 2, 3, 1, 2, 3, 1
        };

        int result = solution(ing);
        System.out.println(result);
    }

    public static int solution(int[] ingredient) {
        int result = 0;
        // 1 2 3 1 -> pop
        Stack<Integer> hamburger = new Stack<>();
        for (int elem : ingredient) {
            hamburger.add(elem);
            int peek = hamburger.peek();
            /***
             * 맨 위에가 1인 경우 쌓인 스택에 값들을 쭉보고 3, 2, 1이면 다 poll
             */
            if (peek == 1) {
                int size = hamburger.size();
                if (size >= 4) {
                    if (hamburger.get(size - 2) == 3 && hamburger.get(size - 3) == 2 && hamburger.get(size - 4) == 1) {
                        result++;
                        hamburger.pop();
                        hamburger.pop();
                        hamburger.pop();
                        hamburger.pop();
                    }
                }
            }
        }
        return result;
    }
}
