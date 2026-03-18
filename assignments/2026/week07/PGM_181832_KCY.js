// PGM 181832 - 정수를 나선형으로 배치하기
// 유형: 구현
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/181832

function solution(n) {
    const answer = Array.from({ length: n }).map(() => Array.from({ length: n }).map(() => 0))

    const direction = [{ x: 1, y: 0 }, { x: 0, y: 1 }, { x: -1, y: 0 }, { x: 0, y: -1 }];

    const switchDirection = (direction, currentDirection) => {
        const targetIndex = direction.findIndex((e) => e === currentDirection);
        const plusIndex = targetIndex + 1;
        return direction[plusIndex % direction.length];
    }

    const checkChangeDirection = (answer, length, currentStep, currentDirection) => {
        const checkStep = {
            x: currentStep.x + currentDirection.x,
            y: currentStep.y + currentDirection.y
        };
        if (checkStep.x < 0 || checkStep.y < 0 || checkStep.x > length - 1 || checkStep.y > length - 1) {
            return true;
        }
        if (answer[checkStep.x][checkStep.y] !== 0) {
            return true;
        }
        return false;
    }

    const startNum = 1
    const lastNum = n * n;
    const length = n;
    let currentNum = startNum;
    let currentDirection = direction[0];
    let currentStep = { x: -1, y: 0 }

    for (let i = startNum; i <= lastNum; i++) {
        currentStep.x = currentStep.x + currentDirection.x;
        currentStep.y = currentStep.y + currentDirection.y;
        answer[currentStep.x][currentStep.y] = i;

        if (i === lastNum) {
            break;
        }

        const changeDirection = checkChangeDirection(answer, length, currentStep, currentDirection);
        if (changeDirection) {
            currentDirection = switchDirection(direction, currentDirection);
        }

    }

    const transtedAnswer = Array.from({ length: n }).map(() => Array.from({ length: n }).map(() => 0)).map((e, y) => {
        return e.map((v, x) => {
            return answer[x][y]
        })
    });

    return transtedAnswer;
}