// PGM 49993 - 스킬트리
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/49993
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String tree : skill_trees){
            
            String filterStr = tree.replaceAll("[^"+skill+"]","");
            
            if(skill.startsWith(filterStr)){
                answer++;
            }
                
        }
        return answer;
    }
}
