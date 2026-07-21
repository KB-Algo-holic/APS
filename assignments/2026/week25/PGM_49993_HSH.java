package week25;

public class PGM_49993_HSH {

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };

        PGM_49993_HSH solution = new PGM_49993_HSH();
        int result = solution.solution(skill, skill_trees);

        System.out.println(result); // 2ß
    }

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skillTree : skill_trees) {
            StringBuilder filtered = new StringBuilder();

            // 선행 스킬과 관련된 문자만 추출
            for (char currentSkill : skillTree.toCharArray()) {
                if (skill.indexOf(currentSkill) != -1) {
                    filtered.append(currentSkill);
                }
            }

            // 추출한 문자열이 skill의 앞부분과 일치하는지 확인
            if (skill.startsWith(filtered.toString())) {
                answer++;
            }
        }

        return answer;
    }
}