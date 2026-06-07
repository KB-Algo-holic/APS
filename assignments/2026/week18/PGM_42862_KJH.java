// PGM 42862 - 체육복
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/42862
import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i = 0 ; i< lost.length ; i++){
            
            for(int j=0; j<reserve.length ; j++){
                
                if(lost[i] == reserve[j]){
                    lost[i] = 0 ;
                    reserve[j] = 0;
                    answer ++;
                    break;
                } 
            }
        }
        
        for(int i = 0 ; i< lost.length ; i++){
            if(lost[i] == 0)
                continue;
            
            for(int j=0; j<reserve.length ; j++){
                
                if(reserve[j] == 0)
                    continue;
                
                if(lost[i] == reserve[j]-1){ 
                    reserve[j] = 0;
                    answer ++;
                    break;
                }
                else if(lost[i] == reserve[j]+1){
                    reserve[j] = 0;
                    answer ++;
                    break;
                }
            }
        }
        return answer;
    }
}
