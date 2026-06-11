// PGM 42884 단속카메라
// 그리디
// https://school.programmers.co.kr/learn/courses/30/lessons/42884


import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int result =0;
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        int position = routes[0][1];
        result++;
        
        for(int i=1;i<routes.length;i++){
            // 진입 지점이 지금 내 카메라 위치에 잡히나?
            if(routes[i][0]<=position){
                continue;
            }
            
            // 안잡힌다. 새로운 카메라 설치
            position = routes[i][1];
            result++;
        }
        
        return result;
    }
}