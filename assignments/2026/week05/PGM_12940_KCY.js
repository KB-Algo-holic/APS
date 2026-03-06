// PGM 12940 - 최대공약수와 최소공배수
// 유형: 구현
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12940

function solution(n, m) {
    let check;
    let answer = [];
    if (n >= m) {
        check = m;
    } else {
        check = n;
    }
    for (let i = check; i > 1; i--) {
        if (n % i === 0 && m % i === 0) {
            answer.push(i, i * (n / i) * (m / i));
            break;
        }
    }
    if (!answer.length) {
        answer = [1, n * m]
    }
    return answer;
}