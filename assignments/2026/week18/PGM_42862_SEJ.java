// PGM 42862 체육복
// 유형 : 그리디
// https://school.programmers.co.kr/learn/courses/30/lessons/42862


import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int result = 0;
        
        boolean[] isPossible = new boolean[n+1];  // 체육수업을 들을수 있는가?
        boolean[] canBorrow = new boolean[n+1];   // 빌려줄수 있는가?
        
        // 체육수업을 들을수 없는 사람 판단
        Arrays.fill(isPossible, true);
        for(int p : lost){
            isPossible[p] = false;
        }
        
        // 빌려줄 수 있는 사람 판단
        for(int p : reserve){
            if(!isPossible[p]){
                isPossible[p] = true;
                continue;
            }
            canBorrow[p] = true;
        }
        
        // greedy? 걍 빌려줄수 있음 무조건 빌려준다
        for(int i=1;i<n+1;i++){
            if(isPossible[i]) {
                result+=1;
                continue; // 수업들을 수 있으면? 걍 넘어간다.
            }
            
            // 수업을 들을 수 없는 경우
            // 1) 앞 사람에게서 빌릴수 있나?
            if(canBorrow[i-1]){
                canBorrow[i-1] = false;
                isPossible[i] = true; // 있어도 그만 없어도 그만인 로직
                result +=1;
                continue;
            }
            
            // 2) 뒷 사람에게서 빌릴 수 있나?
            if(i+1 < n+1 && canBorrow[i+1]){
                canBorrow[i+1] = false;
                isPossible[i] = true; // 있어도 그만 없어도 그만인 로직
                result +=1;
            }
                                   
                               
        }
        
        return result;
    }
}