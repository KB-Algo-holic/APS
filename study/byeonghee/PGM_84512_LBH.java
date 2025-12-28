// PGM 84512 - 모음 사전
// 유형: DFS
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/84512

class Solution {
    String[] moeum = {"A", "E", "I", "O", "U"};
    int count = 0;
    boolean finish = false;

    void DFS(String target, String word) {
        if(target.equals(word)){
            finish = true;
            return;
        }

        if(target.length() == 5) {
            return;
        }

        for(int i = 0; i < 5; i++) {
            if(!finish) {
                count++;
                DFS(target + moeum[i], word);
            }
        }
    }

    public int solution(String word) {
        DFS("", word);

        return count;
    }
}