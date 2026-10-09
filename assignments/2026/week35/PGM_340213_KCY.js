// PGM 340213 - 동영상 재생기
// 유형: 구현
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/340213
function solution(video_len, pos, op_start, op_end, commands) {
    var answer = '';

    const videoLenTime = setTime(video_len);
    const posTime = setTime(pos);
    const opStartTime = setTime(op_start);
    const opEndTime = setTime(op_end);
    let posMove = posTime;

    if (opStartTime <= posMove && posMove <= opEndTime) {
        posMove = opEndTime;
    }

    commands.forEach((command) => {

        if (command === 'next') {
            posMove = posMove + 10 > videoLenTime ? videoLenTime : posMove + 10;
        }
        if (command === 'prev') {
            posMove = posMove - 10 < 0 ? 0 : posMove - 10;
        }

        if (opStartTime <= posMove && posMove <= opEndTime) {
            posMove = opEndTime;
        }
    })
    answer = setTimeStr(posMove)

    return answer;
}

function setTime(str) {
    const [min, sec] = str.split(":").map(e => Number(e));
    return min * 60 + sec;
}
function setTimeStr(num) {
    const min = String(Math.floor(num / 60)).padStart(2, "0");
    const sec = String(num % 60).padStart(2, "0");
    return min + ":" + sec;
}