// 최소직사각형
// 완전탐색
// https://school.programmers.co.kr/learn/courses/30/lessons/86491

class Solution {
    public int solution(int[][] sizes) {
        int wMax = 0;
        int hMax = 0;
        
        for(int i = 0; i < sizes.length; i++) {
            if(sizes[i][0] < sizes[i][1]) {
                if(wMax < sizes[i][1]) {
                    wMax = sizes[i][1];
                }
                if(hMax < sizes[i][0]) {
                    hMax = sizes[i][0];
                }    
            } else {
                if(wMax < sizes[i][0]) {
                    wMax = sizes[i][0];
                }
                if(hMax < sizes[i][1]) {
                    hMax = sizes[i][1];
                }
            }
        }
        
        return wMax * hMax;
    }
}
