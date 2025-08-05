# PGM 150370 - 개인정보 수집 유효기간
# 유형: 문자열
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/150370

def date_to_days(day):
    y, m, d = map(int, day.split('.'))
    return d + 28 * (m + 12 * y)

def solution(today, terms, privacies):
    answer = []
    y, m, d = map(int, today.split('.'))
    today = date_to_days(today)
    
    term = {}
    for t in terms:
        dst, duration = map(str, t.split())
        term[dst] = 28 * int(duration)
    
    for i in range(len(privacies)):
        privacy = privacies[i]
        date, dst = map(str, privacy.split())
        days = date_to_days(date)
        if days + term[dst] <= today:
            answer.append(i+1)
    
    return answer