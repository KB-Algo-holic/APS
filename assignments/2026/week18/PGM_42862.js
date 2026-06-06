// PGM 42862 - 체육복
// 유형: 구현
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42862
function solution(n, lost, reserve) {
    let l = lost.sort((a, b) => a - b);
    let r = reserve.sort((a, b) => a - b);

    for (let i = 0; i < r.length; i++) {
        if (l.find((e) => e === r[i])) {
            l.splice(l.indexOf(r[i]), 1);
            r.splice(i, 1);
            i--;
        }
    }

    for (let i = 0; i < r.length; i++) {
        if (l.find((e) => e === r[i] - 1)) {
            l.splice(l.indexOf(r[i] - 1), 1);
            continue;
        } else if (l.find((e) => e === r[i] + 1)) {
            l.splice(l.indexOf(r[i] + 1), 1);
        }
    }
    return (n - l.length);
}