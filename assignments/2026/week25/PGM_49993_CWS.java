// PGM 49993 - 스킬트리
// 그래프
// https://school.programmers.co.kr/learn/courses/30/lessons/49993

import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i = 0; i < skill_trees.length; i++){
            int skillCnt = 0;
            boolean skillUp = true;
            for(int j = 0; j < skill_trees[i].length(); j++){
                if(skill.contains(skill_trees[i].charAt(j)+"")){
                    if(skill.charAt(skillCnt) == skill_trees[i].charAt(j)){
                        skillCnt++;
                        if(skillCnt == skill.length()){
                            break;
                        }
                    }else{
                        skillUp = false;
                        break;
                    }
                }
            }
            if(skillUp){
                answer++;
            }
        }
        return answer;
    }
}