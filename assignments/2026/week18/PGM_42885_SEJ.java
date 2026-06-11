// PGM 42885 구명보트
// 투포인터
// https://school.programmers.co.kr/learn/courses/30/lessons/42885


import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int result = 0;
        
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length-1;
        
        while(left<=right){
            // 뚱뚱아 날씬이랑 탈 수 있어?
            if(people[right] + people[left]>limit){
                // 아니~! 못타~!
                result ++;
                right --;
            }else{
                // 웅~! 탈수 있어~!
                left ++;
                right --;
                result ++;
            }
        }
    
        
        
        return result;
    }
}