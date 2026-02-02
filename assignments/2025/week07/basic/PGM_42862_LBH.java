// PGM 42862 - 체육복
// 유형: 그리디
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42862

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] clothes = new int[n + 2];

        for(int i = 0; i < lost.length; i++) {
            clothes[lost[i]] = -1;
        }

        for(int i = 0; i < reserve.length; i++) {
            clothes[reserve[i]]++;
        }

        for(int i = 0; i <= n; i++){
            if(clothes[i] == -1) {
                if(clothes[i - 1] == 1) {
                    clothes[i - 1] = 0;
                    clothes[i]++;
                } else if(clothes[i + 1] == 1) {
                    clothes[i + 1] = 0;
                    clothes[i]++;
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            if(clothes[i] >= 0) {
                answer++;
            }
        }

        return answer;
    }
}