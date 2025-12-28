// PGM 17679 - 프렌즈4블록
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/17679

import java.util.*;

class Solution {

    boolean check(char[][] board, int i, int j) {
        if(board[i][j] != '0'
                && board[i][j] == board[i][j + 1]
                && board[i][j] == board[i + 1][j]
                && board[i][j] == board[i + 1][j + 1]) {
            return true;
        }
        return false;
    }

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] charBoard = new char[m][];
        for(int i = 0; i < m; i++) {
            charBoard[i] = board[i].toCharArray();
        }

        while(true){
            Set<List<Integer>> set = new HashSet<>();

            for(int i = 0; i < m - 1; i++) {
                for(int j = 0; j < n - 1; j++) {
                    if(check(charBoard, i, j)) {
                        set.add(Arrays.asList(i, j));
                        set.add(Arrays.asList(i, j + 1));
                        set.add(Arrays.asList(i + 1, j));
                        set.add(Arrays.asList(i + 1, j + 1));
                    }
                }
            }

            answer += set.size();

            if(set.isEmpty()) {
                break;
            }

            for(List<Integer> list : set) {
                charBoard[list.get(0)][list.get(1)] = '0';
            }

            for(int j = 0; j < n; j++) {
                for(int i = m - 1; i > 0; i--) {
                    if(charBoard[i][j] == '0') {
                        for(int k = i - 1; k >= 0; k--) {
                            if(charBoard[k][j] != '0') {
                                charBoard[i][j] = charBoard[k][j];
                                charBoard[k][j] = '0';
                                break;
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }
}