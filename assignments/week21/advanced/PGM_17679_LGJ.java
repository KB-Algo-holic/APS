import java.util.*;

class Solution {
    static int[] dr = {1, 0, 1};
    static int[] dc = {0, 1, 1};
    static int answer = 0;

    public static int solution(int m, int n, String[] board) {
        //System.out.println(Arrays.toString(board));
        deleteBoard(m, n, board);
        return answer;
    }

    public static void deleteBoard(int m, int n, String[] board) {
        Set<List<Integer>> deleted = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char cur = board[i].charAt(j);
                if (cur == '$' || cur == '#') continue;
                List<List<Integer>> sames = new ArrayList<>();
                sames.add(Arrays.asList(i, j));
                for (int k=0; k<3; k++) {
                    int nr = i+dr[k];
                    int nc = j+dc[k];
                    if (nr >= m || nc >= n) break;
                    if (board[nr].charAt(nc) == '$' || board[nr].charAt(nc) == '#') break;
                    if (board[nr].charAt(nc) == cur) sames.add(Arrays.asList(nr, nc));
                }
                if (sames.size() == 4) {
                    //for (List<Integer> s: sames) System.out.println(s);
                    deleted.addAll(sames);
                }
            }
        }

        if (!deleted.isEmpty()) {
            //System.out.println(deleted);
            answer += deleted.size();
            deleteBoard(m, n, makeNewBoard(m, n, board, deleted));
        }
    }

    public static String[] makeNewBoard(int m, int n, String[] board, Set<List<Integer>> deleted) {

        // 검사 전 삭제된 문자열 = 'X'
        for (List<Integer> d: deleted) {
            int r = d.get(0);
            int c = d.get(1);
            StringBuilder newString = new StringBuilder(board[r]);
            newString.setCharAt(c, '#');
            board[r] = newString.toString();
        }
        System.out.println(Arrays.toString(board));

        // 대체 후 삭제된 빈 문자열 = '$'
        for (int i = m-1; i >= 0; i--) {
            StringBuilder row = new StringBuilder(board[i]);
            for (int j=0; j<n; j++) {
                int r = i;
                //System.out.println(row);
                if (row.charAt(j) == '#' || row.charAt(j) == '$') {
                    // 위에 존재하는 문자열 가져옴
                    r --;
                    while (r >= 0) {
                        if (board[r].charAt(j) != '#' && board[r].charAt(j) != '$') {
                            StringBuilder temp = new StringBuilder(board[r]);
                            row.setCharAt(j, temp.charAt(j)); // X > 위 문자열
                            temp.setCharAt(j, '$'); // 아래로 내린 문자열 = O
                            board[r] = temp.toString();
                            break;
                        }
                        r --;
                    }
                    // 찾았는데 더이상 없다면
                    if (row.charAt(j) == '#') row.setCharAt(j, '$');
                }
            }
            board[i] = row.toString();
        }
        //System.out.println(Arrays.toString(board));
        return board;
    }
}