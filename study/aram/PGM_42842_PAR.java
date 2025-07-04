# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 42842 - 카펫
# 유형: 완전탐색
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42842

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        for(int c = 1; c <= Math.sqrt(yellow); c++) {
            if(yellow % c == 0) {
                int r = yellow / c;
                
                if(r *2 + c * 2 + 4 == brown) {
                    answer = new int[] {r + 2, c + 2};
                    break;
                }
            }
        }
        
        return answer;
    }
}