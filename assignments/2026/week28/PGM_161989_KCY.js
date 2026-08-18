// PGM 161989 - 덧칠하기
// 유형: 구현
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/161989
function solution(n, m, section) {
    let answer = 0;
    let painted = 0;

    for (let i = 0; i < section.length; i++) {
        if (section[i] > painted) {
            painted = section[i] + m - 1;
            answer++;
        }
    }

    return answer;
}