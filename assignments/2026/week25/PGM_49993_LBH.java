// 스킬트리
// 해쉬
// https://school.programmers.co.kr/learn/courses/30/lessons/49993?language=java

import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        HashMap<Character, Integer> learnedMap = new HashMap<>();
        for(int i = 0; i < skill.length(); i++) {
            char learn = skill.charAt(i);
            learnedMap.put(learn, i);
        }
        
        for(String skillTree : skill_trees) {
            boolean[] learned = new boolean[skill.length()];
            boolean isPossible = true;
            
            for(int i = 0; i < skillTree.length(); i++) {
                char s = skillTree.charAt(i);
                if(learnedMap.get(s) != null) {
                    if(learnedMap.get(s) == 0) {
                        learned[learnedMap.get(s)] = true;
                    } else {
                        if (learned[learnedMap.get(s) - 1] == true) {
                            learned[learnedMap.get(s)] = true;
                        } else {
                            isPossible = false;
                            break;
                        }
                    }
                }
            }
            
            if(isPossible) {
                answer++;
            }
        }
        
        return answer;
    }
}
