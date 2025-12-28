// PGM 42862 - 체육복
// 유형 : 그리디
// 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42862

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] student = new int[n];
        
        int lostIdx    = lost.length-1;
        int reserveIdx = reserve.length-1;
        int value;
        
        for (int i=n-1; i>=0; i--) {
            value = 1;
            
            if (lost[lostIdx]-1 == i) {
                if (lostIdx > 0) lostIdx--;
                value--;
            }
            
            if (reserve[reserveIdx]-1 == i) {
                if (reserveIdx > 0) reserveIdx--;
                value++;
            }
            
            student[i] = value;
        }
        
        
        
        for (int i=0; i<n-1; i++) {
            if (student[i] == 2 && student[i+1] == 0) {
                student[i]   = 1;
                student[i+1] = 1;
                i++;
            }
        }
        
        for (int i=n-1; i>0; i--) {
            if (student[i] == 2 && student[i-1] == 0) {
                student[i]   = 1;
                student[i-1] = 1;
                i--;
            }
        }
            
        for (int i=0; i<n; i++) {
            if (student[i] >= 1) answer++;
        }
        
        return answer;
    }
}