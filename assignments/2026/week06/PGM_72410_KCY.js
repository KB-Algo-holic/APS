// PGM 72410 - 신규 아이디 추천
// 유형: 구현
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/72410

function solution(new_id) {
    const steps = [step1, step2, step3, step4, step5, step6, step7];
    const answer = steps.reduce((acc, cur) => cur(acc), new_id);
    return answer;
}

function step1(str) {
    return str.toLowerCase();
}
function step2(str) {
    return str.replace(/[^a-z0-9\-_.]/g, '');
}
function step3(str) {
    while (str.includes('..')) {
        str = str.replaceAll('..', '.');
    }
    return str;
}
function step4(str) {
    if (str.startsWith('.')) str = str.slice(1);
    if (str.endsWith('.')) str = str.slice(0, -1);
    return str;
}
function step5(str) {
    return str === '' ? 'a' : str;
}
function step6(str) {
    str = str.length >= 16 ? str.slice(0, 15) : str;
    if (str.endsWith('.')) str = str.slice(0, -1);
    return str;
}
function step7(str) {
    while (str.length < 3) {
        str += str[str.length - 1];
    }
    return str;
}