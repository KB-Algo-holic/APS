// PGM 468370 - 중요한 단어를 스포 방지
// 유형: 구현
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/468370

function solution(message, spoiler_ranges) {
    let answer = 0;
    const blurTag = "*"

    const blurMessages = genBlurMessage(message, spoiler_ranges, blurTag);

    const blurMessageArr = blurMessages.split(" ");
    const messageArr = message.split(" ");
    // 과정에서 사용    
    const blurProcessMessageArr = blurMessages.split(" ");

    blurMessageArr.forEach((e, i) => {
        const isContainBlur = e.includes(blurTag);
        if (isContainBlur) {
            const clearMsg = messageArr[i];
            const isImportant = !blurProcessMessageArr.find((v) => v === clearMsg);
            if (isImportant) {
                answer = answer + 1;
            }
            blurProcessMessageArr[i] = clearMsg;
        }
    })

    return answer;
}

function genBlurMessage(message, spoiler_ranges, blurTag) {
    let messageArr = message.split("");
    spoiler_ranges.forEach((e) => {
        const startIdx = e[0];
        const lastIdx = e[1];
        for (let cnt = startIdx; cnt <= lastIdx; cnt++) {
            if (messageArr[cnt] === " ") {
                continue;
            }
            messageArr[cnt] = blurTag;
        }
    });
    const messageStr = messageArr.join("");
    return messageStr;
}

