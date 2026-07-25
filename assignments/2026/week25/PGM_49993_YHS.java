// PGM - 49993 스킬트리
// 그래프
// https://school.programmers.co.kr/learn/courses/30/lessons/49993
import java.util.HashMap;
import java.util.Map;

public class PGM_49993_YHS {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<skill.length(); i++){
            char c = skill.charAt(i);
            map.put(c, i+1);
        }

        outer: for(int i=0; i<skill_trees.length; i++){
            int cnt = 1;
            for(int j=0; j<skill_trees[i].length(); j++){
                char c = skill_trees[i].charAt(j);
                // System.out.println(c);

                if(map.get(c) != null){
                    if(map.get(c) == cnt){
                        cnt++;
                    }else{
                        // System.out.println();
                        continue outer;
                    }
                }
            }
            answer++;
            System.out.println();
        }


        return answer;
    }
}
