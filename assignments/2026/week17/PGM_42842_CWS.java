// PGM 42842 - 카펫
// 완전탐색
// https://school.programmers.co.kr/learn/courses/30/lessons/42842

class Solution {
    public int[] solution(int brown, int yellow) {

        int x = yellow;
        int y = 1;
        while(true){
            if(brown == (x+2)*2 + y*2) break;
            while(true){
                y++;
                if(yellow % y == 0){
                    x = yellow/y;
                    break;
                }
            }
        }
        int[] answer = {x+2, y+2};
        return answer;
    }
}