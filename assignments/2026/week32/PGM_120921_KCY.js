// PGM 120921 - 문자열 밀기
// 유형: 구현
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/120921

function solution(A, B) {
    if (A === B) return 0;

    let arr = A.split('');
    for (let i = 1; i < A.length; i++) {
        const last = arr.pop();
        arr.unshift(last);
        const str = arr.join('');
        if (str === B) {
            return i;
        }
    }
    return -1;
}