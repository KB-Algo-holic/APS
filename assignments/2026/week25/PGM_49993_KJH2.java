// PGM 49993 스킬트리
// QUEUE로 비교해서 구현.. 
// https://school.programmers.co.kr/learn/courses/30/lessons/49993?language=java
import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Queue<Character> que = new LinkedList<>();
        for (int i = 0; i < skill.length(); i++) {
            que.add(skill.charAt(i));
        }

        for (String skill_tree : skill_trees) {
            
            Queue<Character> que_cpy = new LinkedList<>(que);
            
            boolean isValid = true; 
            for (int j = 0; j < skill_tree.length(); j++) {
                char currentSkill = skill_tree.charAt(j);
                if(que_cpy.contains(currentSkill)){
                    if(currentSkill == que_cpy.peek())
                        que_cpy.poll();
                    else
                    {
                        isValid = false;
                        break;
                    }
                }
            }
            if (isValid) {
                answer++;
            }
        }

        return answer;
    }
}
