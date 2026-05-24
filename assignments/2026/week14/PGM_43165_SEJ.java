// PGM 43165 - 타겟넘버
// dfs
// https://school.programmers.co.kr/learn/courses/30/lessons/43165?language=java

using System;

public class Solution {
    int result =0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0,0,0);
       return result;
    }
    
    public void dfs(int[] numbers, int target, int cnt, int start, int sum){
        if(cnt==numbers.Length){
            if(sum==target){
                result++;
            }
            return;
        }
        
      
            //지금 내가 할 수 있는 행위는 해당 num을 더하거나 빼거나
            dfs(numbers, target, cnt+1, start+1, sum+numbers[start]);
            dfs(numbers, target, cnt+1, start+1, sum-numbers[start]);
        
    }
    
    

}