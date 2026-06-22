// PGM 12924 - 숫자의 표현
// 유형: 구현
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12924
function solution(n) {
    let answer = 0;

    for (let i = 1; i <= n; i = i + 2) {
        if (n % i === 0) {
            answer++;
        }
    }
    return answer;
}