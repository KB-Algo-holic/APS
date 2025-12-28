# PGM 개인정보 수집 유효기간
# 문자열
# https://school.programmers.co.kr/learn/courses/30/lessons/150370

def solution(today, terms, privacies):
    answer = []
    today = make_date_to_days(today)
    term_dict = {}
    for term in terms:
        t, m = term.split(" ")
        term_dict[t] = int(m)
    
    for idx, value in enumerate(privacies):
        str_date, term = value.split(' ') 
        join_day = make_date_to_days(str_date)
        
        if today >= (join_day + (term_dict[term] * 28)):
            answer.append(idx+1)

    return answer

def make_date_to_days(str_date):
    year, month, day = map(int, str_date.split('.'))
    int_date = year * 12 * 28 + month * 28 + day
    return int_date