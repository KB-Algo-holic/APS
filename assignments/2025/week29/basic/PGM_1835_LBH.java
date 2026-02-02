// PGM 1835 - 단체사진 찍기
// DFS
// https://school.programmers.co.kr/learn/courses/30/lessons/1835

class Solution {

    char[] friends = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    char[] line = new char[8];
    boolean[] visit = new boolean[8];
    int answer = 0;

    void DFS(String[] data, int idx) {
        if(idx == 8) {
            answer++;
            return;
        }

        for(int i = 0; i < 8; i++) {
            if(!visit[i]) {
                line[idx] = friends[i];
                boolean isPossible = true;

                if(idx > 0) {
                    for(int j = 0; j < data.length; j++) {
                        char first = data[j].charAt(0);
                        char second = data[j].charAt(2);
                        char oper = data[j].charAt(3);
                        int dist = data[j].charAt(4) - '0';

                        if(first == friends[i] || second == friends[i]) {
                            for(int k = 0; k < idx; k++) {
                                if(first == line[k] || second == line[k]) {
                                    int temp = Math.abs(k - idx) - 1;
                                    if((oper == '=' && dist != temp) || (oper == '>' && dist >= temp) || (oper == '<' && dist <= temp)) {
                                        isPossible = false;
                                        j = data.length;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }

                if(isPossible) {
                    visit[i] = true;
                    DFS(data, idx+1);
                    visit[i] = false;
                }
            }

            line[idx] = '0';
        }
    }

    public int solution(int n, String[] data) {

        DFS(data, 0);

        return answer;
    }
}