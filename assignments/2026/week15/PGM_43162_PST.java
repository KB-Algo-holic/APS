// PGM 43162 - 네트워크
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/43162?language=java

import java.util.ArrayList;

public class PGM_43162_PST {
    class Solution {
        public int solution(int n, int[][] computers) {
            int answer = 0;

            ArrayList<Boolean> connectedList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                connectedList.add(false);
            }

            for (int i = 0; i < n; i++) {

                if (connectedList.get(i) == false) {
                    checkNetwork(i, n, computers, connectedList);
                    answer++;
                }
            }

            return answer;
        }

        private void checkNetwork(int current, int n, int[][] computers, ArrayList<Boolean> connectedList) {
            connectedList.set(current, true);

            for (int next = 0; next < n; next++) {
                if (current != next && computers[current][next] == 1 && connectedList.get(next) == false) {
                    checkNetwork(next, n, computers, connectedList);
                }
            }
        }
    }
}
