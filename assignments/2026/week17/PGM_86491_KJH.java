// PGM 86491 - 최소직사각형
// 구현
// hhttps://school.programmers.co.kr/learn/courses/30/lessons/86491
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int width = 0;
        int height = 0;
        
        for(int[] size : sizes){
            
            int x = Math.max(size[0], size[1]);
            int y = Math.min(size[0], size[1]);
            
            width = width <x ? x:width;
            height = height <y? y:height;
        }
        answer = width * height;
        
        return answer;
    }
}
