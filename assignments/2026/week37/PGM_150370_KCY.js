// PGM 150370 - 개인정보 수집 유효기간
// 유형: 구현
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/150370
function solution(today, terms, privacies) {
    var answer = [];
    
    const todayTime = formatDateNum(today);
    const termsSet = Object.fromEntries(terms.map((e)=>e.split(" ")));
    privacies.forEach((e, i)=>{
        const [dateStr, termKey] = e.split(" ");
        const expiredDateTime = getExpired(dateStr, termsSet[termKey]);
        if(todayTime > expiredDateTime){
            answer.push(i +1)
        }
    })
    
    return answer;
}

function getExpired(dateStr, term){
    const termNum = Number(term);
    return formatDateNum(dateStr) + termNum * 28 - 1;
}

function formatDateNum(dateStr){
    const [year, month, day] = dateStr.split(".").map((e)=>Number(e));
    return year * 12 * 28 + month * 28 + day;
}