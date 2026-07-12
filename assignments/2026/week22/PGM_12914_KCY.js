// PGM 12914 - 멀리 뛰기
// 유형: 구현
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12914
function solution(n) {
    if (n === 1) return 1;
    if (n === 2) return 2;

    let prev1 = 1;
    let prev2 = 2;

    for (let i = 3; i <= n; i++) {
        let current = (prev1 + prev2) % 1234567;

        prev1 = prev2;
        prev2 = current;
    }

    return prev2;
}