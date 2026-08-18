// PGM 161989 - 덧칠하기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/161989
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0; 
        int paintedUntil = 0;  

        for (int sec : section) { 
            if (sec > paintedUntil) {
                answer++; 
                paintedUntil = sec + m - 1;
            }
        }
        return answer;
    }
}
