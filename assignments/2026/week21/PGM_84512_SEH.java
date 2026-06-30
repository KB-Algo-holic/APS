// PGM 84512 모음사전
// 완탐(DFS)
// https://school.programmers.co.kr/learn/courses/30/lessons/84512?language=java


import java.util.*;
class Solution {
    String[] w = new String[]{"A", "E", "I", "O", "U"};
    int result =0;
    boolean isFound = false;
    public int solution(String word) {
        
        permutation(new StringBuilder(), word);
        
        return result;
    }
    
    public void permutation(StringBuilder str, String word){
        if(isFound) return;
        
        if(str.length()>0) result++;
        
        if(word.equals(str.toString())){
            isFound = true;
            return;
        }
        
        if(str.length()==5){
            // 5자리가 최대임
            return;
        }
        
        for(int i=0;i<5;i++){
            str.append(w[i]);
            permutation(str, word);
            str.deleteCharAt(str.length() - 1);
        }

    }
}