// https://school.programmers.co.kr/learn/courses/30/lessons/49993
// PGM 49993 스킬트리
// 트리

import java.util.*;
import java.io.*;



class Solution {
    int[] preEdu = new int[26]; // 알파벳은 26개
    ArrayList<Integer>[] info;
    
    public int solution(String skill, String[] skill_trees) {
        int result = 0;
           
        init(skill);
        
        int[] eduStatus;
        boolean isPossible;
        
        for(String skillTree : skill_trees){
            eduStatus = preEdu.clone();
            isPossible = true;
            
            for(int i=0 ; i<skillTree.length();i++){
                int cur = skillTree.charAt(i) - 'A';
                
                //만약 eduStatus가 0이면? 지금 내가 가능한 skill이다.
                if(eduStatus[cur] > 0 ){
                    isPossible = false;
                    break;
                }
                
                // 지금 배울 수 있는 스킬이다 -> 그럼 내 뒤에 있는 에들 eduStatus줄여주기
                for(int j : info[cur]){
                    eduStatus[j] -=1;
                }
                
            }
            
            if(isPossible) result ++;
        }
        
        
        
        
        return result;
    }
    
    
    public void init (String skill){
        Arrays.fill(preEdu, 0); // 일단 다 0으로 채운다
        
        // ex) CBD일때 내가 해야할일 -> 0 1 2로 배열을 만들어줘야 한다.
        for(int i=0;i<skill.length();i++){
            int idx = skill.charAt(i)-'A';
            preEdu[idx] = i;
        }
        
        
        info = new ArrayList[26];
        for(int i=0;i<26;i++){
            info[i] = new ArrayList<Integer>();
        }
        
        for(int i=0;i<skill.length();i++){
            int idx = skill.charAt(i) - 'A';
            
            for(int j = i+1; j<skill.length();j++){
                int child = skill.charAt(j)-'A';
                info[idx].add(child);
            }
        }
        
    }
}
