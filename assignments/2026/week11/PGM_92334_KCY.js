// PGM 92334 - 신고 결과 받기
// 유형: 구현
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/92334

function solution(id_list, report, k) {
    const resultSet = Object.fromEntries(id_list.map((e) => [e, 0]))
    const calSet = Object.fromEntries(id_list.map(e => [e, { count: 0, to: [] }]))
    const uniqReport = [...new Set(report)]
    uniqReport.forEach((e) => {
        const reportElArr = e.split(" ")
        const to = reportElArr[0]
        const from = reportElArr[1]

        const target = calSet[from]
        target.count = target.count + 1
        target.to.push(to)
    })
    Object.values(calSet).filter(e => e.count >= k).forEach((e) => {
        e.to.forEach((k) => {
            resultSet[k] = resultSet[k] + 1
        })
    })
    const result = Object.values(resultSet)
    return result

}