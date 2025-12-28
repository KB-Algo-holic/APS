// PGM 42860 - 조이스틱
// 그리디
// https://school.programmers.co.kr/learn/courses/30/lessons/42860

class Solution {
    public int solution(String name) {
        int answer = 0;

        // right
        int move = name.length() - 1;
        for(int i = 0; i < name.length(); i++) {
            int next = i + 1;
            while(next < name.length() && name.charAt(next) == 'A') {
                next++;
            }

            move = Math.min(move, 2 * i + name.length() - next);
            move = Math.min(move, 2 * (name.length() - next) + i);
        }

        answer += move;

        // up, down
        for(int i = 0; i < name.length(); i++) {
            if(name.charAt(i) <= 'N') {
                answer += (int)name.charAt(i) - (int)'A';
            } else {
                answer += (int)'Z' - (int)name.charAt(i) + 1;
            }
        }

        return answer;
    }
}