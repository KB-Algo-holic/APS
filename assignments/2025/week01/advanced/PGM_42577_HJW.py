# PGM 42577 - 전화번호 목록
# 유형: 해시
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42577

def solution(phone_book):
    answer = True
    phone_book.sort()
    for i in range(len(phone_book) - 1):
        a = phone_book[i]
        b = phone_book[i+1]
        if a == b[:len(a)]:
            answer = False
            break
    
    return answer