// PGM 49993 - 스킬트리
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/49993?language=java

public class PGM_49993_PST {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String tree : skill_trees) {

            String filtered = tree.replaceAll("[^" + skill + "]", "");

            if (skill.startsWith(filtered)) {
                answer++;
            }
        }

        return answer;
    }
}
