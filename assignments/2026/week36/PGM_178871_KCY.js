// PGM 178871 - 달리기 경주
// 유형: 구현
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/178871
function solution(players, callings) {
    var answer = [];

    const playerSet = Object.fromEntries(players.map((e, i) => [e, i]));

    const currentPos = players;
    callings.forEach((name) => {
        const posNumber = playerSet[name];
        const prevName = currentPos[posNumber - 1];

        playerSet[name] = posNumber - 1;
        playerSet[prevName] = posNumber;

        currentPos[posNumber] = prevName;
        currentPos[posNumber - 1] = name;
    });

    return currentPos;
}