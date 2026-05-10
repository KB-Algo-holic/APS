// PGM 43165 - 타겟 넘버
// 유형: 구현
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43165

function solution(numbers, target) {
    const answer = dfs(0, 0, numbers, target);
    return answer;
}
// 재귀
function dfs(index, sum, numbers, target) {
    const maxLength = numbers.length;
    const addNum = 1;
    if (index === maxLength) {
        if (sum === target) {
            return 1;
        }
        return 0;
    }
    return dfs(index + addNum, sum + numbers[index], numbers, target) + dfs(index + addNum, sum - numbers[index], numbers, target)
}