// PGM 131701 - 연속 부분 수열 합의 개수
// 유형: 구현
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/131701
function solution(elements) {
    const uniqueSums = new Set();
    const n = elements.length;

    const extended = [...elements, ...elements];

    const prefix = new Array(extended.length + 1).fill(0);
    extended.forEach((e, i) => {
        prefix[i + 1] = prefix[i] + extended[i];
    })

    for (let i = 0; i < n; i++) {
        for (let len = 1; len <= n; len++) {
            const sum = prefix[i + len] - prefix[i];
            uniqueSums.add(sum);
        }
    }

    return uniqueSums.size;
}