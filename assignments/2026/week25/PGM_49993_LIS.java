// PGM 49993 - 스킬트리
// 학습 
// https://school.programmers.co.kr/learn/courses/30/lessons/49993
import java.util.Arrays;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int T = skill_trees.length;

        for (int i = 0; i < T; i++) {
            String temp = skill_trees[i];
            char[] cur_skill_trees = temp.toCharArray();
            char[] s = skill.toCharArray();

            int idx = 0;
            boolean stop = false;
            for (int j = 0; j < cur_skill_trees.length; j++) {
                for (int k = 0; k < s.length; k++) {
                    char cur_val = cur_skill_trees[j];
                    if (cur_val == s[k]) {
                        if (s[idx] == cur_val) {
                            idx++;
                        }
                        else {
                            stop = true;
                            break;
                        }
                    }
                    if (stop) break;
                }
                if (stop) break;
            }
            if (!stop) answer++;

        }


        return answer;
    }
}
