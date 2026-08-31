// PGM 76502 - 괄호 회전하기
// 유형: 구현
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/76502
function solution(s) {
    if (s.length % 2 === 1) return 0;
    let answer = 0;
    const matching = {
        ')': '(',
        '}': '{',
        ']': '['
    };

    for (let i = 0; i < s.length; i++) {
        const rotated = s.slice(i) + s.slice(0, i);

        const stack = [];
        let isValid = true;

        for (let char of rotated) {
            if (char === '(' || char === '{' || char === '[') {
                stack.push(char);
            }
            else {
                if (stack.length === 0 || stack.pop() !== matching[char]) {
                    isValid = false;
                    break;
                }
            }
        }

        if (isValid && stack.length === 0) {
            answer++;
        }
    }

    return answer;
}