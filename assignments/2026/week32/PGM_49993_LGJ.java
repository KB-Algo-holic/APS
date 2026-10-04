// PGM 49993 스킬트리
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/49993
// 문자열로 정렬해두면 쉬움, String


import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Set<Character> set = new HashSet<>();

        for (char ch : skill.toCharArray()) {
            set.add(ch);
        }

        for (String skill_tree: skill_trees) {
            String temp = "";
            for (char ch: skill_tree.toCharArray()) {
                if (set.contains(ch)) {
                    temp += ch;
                }
            }
            if (skill.startsWith(temp)) {
                //System.out.println(skill_tree);
                answer ++;
            };

        }


        return answer;
    }
}