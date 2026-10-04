// PGM 181926 - 수 조작하기1
// 유형: 구현
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/181926
function solution(n, control) {
    const arrowSet = { 'w': 1, 's': -1, 'd': 10, 'a': -10 };
    const constrolArr = control.split("");

    return constrolArr.reduce((acc, cur) => arrowSet[cur] + acc, n);
}