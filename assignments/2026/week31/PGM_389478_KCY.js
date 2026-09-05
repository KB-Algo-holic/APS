// PGM 389478 - 택배 상자 꺼내기
// 유형: 구현
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/389478
function solution(n, w, num) {
    let index = 0;
    let count = 1;
    let isPositive = true;
    const nSet = {};
    const indexSet = {};

    while (count <= n) {

        nSet[count] = index;
        if (!indexSet[index]) {
            indexSet[index] = [];
        }
        indexSet[index].push(count);

        count = count + 1;

        if (count - 1 > 0 && (count - 1) % w === 0) {
            continue;
        }

        if (isPositive) {
            index = index + 1;
        } else {
            index = index - 1;
        }

        if (count % w === 0) {
            isPositive = !isPositive
        }

    }

    const searchIndex = nSet[num];
    const searchLines = indexSet[searchIndex]
    searchLines.reverse();
    const findIndex = searchLines.indexOf(num);
    const answer = findIndex + 1;

    return answer;
}