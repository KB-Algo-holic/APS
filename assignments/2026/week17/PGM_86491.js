// PGM 86491 - 최소직사각형
// 유형: 구현
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/86491
function solution(sizes) {
    let maxWidth = 0;
    let maxHeight = 0;

    sizes.forEach(([w, h]) => {
        const width = Math.max(w, h);
        const height = Math.min(w, h);

        maxWidth = Math.max(maxWidth, width);
        maxHeight = Math.max(maxHeight, height);
    });

    return maxWidth * maxHeight;
}