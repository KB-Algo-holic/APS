# PGM 147354 - 테이블 해시 함수
# 유형: 정렬
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/147354

def solution(data, col, row_begin, row_end):
    answer = 0
    
    data.sort(key=lambda x:(x[col-1], -x[0]))
    
    for i in range(row_begin-1, row_end):
        S = 0
        for j in range(len(data[i])):
            S += data[i][j] % (i+1)
        answer ^= S
    
    return answer