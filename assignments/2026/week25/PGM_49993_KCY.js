// PGM 49993 - 스킬트리
// 유형: 구현
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/49993
function solution(skill, skill_trees) {
    const regex = new RegExp(`[^${skill}]`, 'g');

    return skill_trees.filter(tree => {
        const filteredTree = tree.replace(regex, '');
        return skill.startsWith(filteredTree);
    }).length;
}