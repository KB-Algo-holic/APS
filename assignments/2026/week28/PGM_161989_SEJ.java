
// 그리디
// https://school.programmers.co.kr/learn/courses/30/lessons/161989?language=java
import java.util.*;
import java.io.*;

class Solution {
    boolean[] isPainted;
    
    public int solution(int n, int m, int[] section) {
        int result =0;
        
        
        isPainted = new boolean[n];
        
        int idx = 0;
        for(int num : section){
            
            idx = num-1;
            if(isPainted[idx]) continue;
            result ++;
            int maxIdx = Math.min(n, idx+m);
            for(int i=idx ; i<maxIdx; i++){
                isPainted[i] = true;
            }
            
        }
        
        return result;
    }
    
}
