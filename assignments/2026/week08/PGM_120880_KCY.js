// PGM 120880 - 특이한 정렬
// 유형: 구현
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/120880

function solution(numlist, n) {
    var answer = getResult(numlist, n);
    return answer;
}

function getResult(arr, n) {
    const diffList = arr.map((e) => ({ value: e, diff: Math.abs(e - n) }));
    // 내림차순
    diffList.sort((a, b) => b.value - a.value);
    // diff 기준 오름차순
    diffList.sort((a, b) => a.diff - b.diff);

    const result = diffList.map((e) => e.value);
    return result;
}