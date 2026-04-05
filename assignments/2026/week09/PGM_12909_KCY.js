// PGM 12909 - 올바른 괄호
// 유형: 구현
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12909

function solution(s) {
    const stepSet = {
        '(': 1,
        ')': -1
    }

    let openCount = 0;
    let i = 0;
    while (s.length > i) {
        const step = s.charAt(i);
        i = i + 1;

        openCount = openCount + stepSet[step];
        if (openCount < 0) break;
    }

    const answer = openCount === 0 ? true : false
    return answer;
}