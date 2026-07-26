// PGM 49993 - 스킬트리
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/49993?language=java

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String skillTree : skill_trees){
            String tempSkill = skillTree;
            
            for(int i=0; i<skillTree.length(); i++) {
                String s = skillTree.substring(i, i+1);
                if(!skill.contains(s)){
                    tempSkill = tempSkill.replace(s, "");
                }
            }
            if(skill.indexOf(tempSkill) == 0) answer++;
        }
        
        return answer;
    }
}
