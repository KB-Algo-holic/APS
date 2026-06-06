// PGM 42862 - 체육복
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/42862?language=java

import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
         
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
            
            //lost배열과 reserve배열을 돌면서 두 값이 일치할 경우
            // 내가 나에게 빌려준 것으로 간주하고 answer++
            // 그리고 lost,reserve배열의 각 인덱스를 무의미한 값인 -1로 대입하여
            // 더이상 카운팅되지 않도록 처리
            // 그리고 해당 if문을 빠져나감(break)
                if(reserve[j]==lost[i]){
                    answer++;
                    lost[i] =-1;
                    reserve[j] =-1;
                    break;
                }
            }
        }
        
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(reserve[j]==lost[i]-1 || reserve[j]==lost[i]+1){
                    answer++;
                    lost[i]=-1;
                    reserve[j]=-1;
                    break;
                }
            }
        }
        
        return answer;
    }
}
