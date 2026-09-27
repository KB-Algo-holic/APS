// PGM 체육복 - 42862
// 그리디
// https://school.programmers.co.kr/learn/courses/30/lessons/42862
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        int answer = n-lost.length;
        
        for(int i=0;i<lost.length;i++)
        {
            for(int j=0;j<reserve.length;j++)
            {
                if(lost[i] == reserve[j])
                {
                    answer++;
                    lost[i] = 0;
                    reserve[j] = 0;
                    break;
                }
            }
        }
        
        for(int i=0;i<lost.length;i++)
        {
            for(int j=0;j<reserve.length;j++)
            {
                if( (lost[i]-1 == reserve[j] || 
                  lost[i]+1 == reserve[j]) && 
                  lost[i] != 0 && reserve[j] != 0)
                {
                    answer++;
                    lost[i] = 0;
                    reserve[j] = 0;
                }
            }
        }
        
        return answer;
    }
}

