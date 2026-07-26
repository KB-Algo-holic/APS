class Solution {
    public int solution(String skill, String[] skill_trees) {
           int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            StringBuilder sb = new StringBuilder();
            // skill의 문자열을 제외한 나머지 문자 빼버리기
            for (int j = 0; j < skill_trees[i].length(); j++) {
                if (skill.indexOf(skill_trees[i].charAt(j)) != -1) {
                    sb.append(skill_trees[i].charAt(j));
                }
            }

            // skill이 새 문자열로 시작하는지 여부
            if (skill.startsWith(sb.toString())) answer++;
        }

        return answer;
    }
}
