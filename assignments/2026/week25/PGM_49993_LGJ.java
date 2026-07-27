// PGM - 49993 스킬트리
// 구현 및 스택?
// https://school.programmers.co.kr/learn/courses/30/lessons/49993?language=java

import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        List<Character> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for (char c: skill.toCharArray()) {
            list.add(c);
            set.add(c);
        }
        for (String st: skill_trees) {
            Boolean isPossible = true;
            int top = 0;
            for (char c: st.toCharArray()) {
                if (!set.contains(c)) continue;
                if (list.get(top) == c) {
                    top ++;
                } else {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) answer ++;
        }
        return answer;
    }
}
