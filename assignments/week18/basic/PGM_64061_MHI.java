import java.util.Stack;

class Solution {

    public int solution(int[][] board, int[] moves) {

        int N = board.length;
        int[] index = new int[N];

        for(int c=0; c<N; c++) {
            int r = 0;
            while (r < N) {
                if(board[r][c] != 0) break;
                r++;
            }
            index[c] = r;
        }

        Stack<Integer> st = new Stack<>();
        int answer = 0;
        for(int i=0; i<moves.length; i++) {
            int c = --moves[i];
            int r = index[c];

            if(r < N) {
                if (!st.isEmpty() && st.peek() == board[r][c]) {
                    st.pop();
                    answer+=2;
                } else {
                    st.push(board[r][c]);
                }
                index[c]++;
            }
        }
        return answer;
    }
}