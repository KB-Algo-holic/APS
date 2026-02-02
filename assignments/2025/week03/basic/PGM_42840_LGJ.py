# PGM 42840 - 모의고사
# 유형: 완전탐색
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42840

def solution(answers):
    first = [1, 2, 3, 4, 5]
    second = [2, 1, 2, 3, 2, 4, 2, 5]
    third = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    first_cnt = 0
    second_cnt = 0
    third_cnt = 0
    
    for i in range(len(answers)):
        cur_answer = answers[i]
        first_idx = i % 5
        second_idx = i % 8
        third_idx = i  % 10
        if first[first_idx] == cur_answer:
            first_cnt += 1
        if second[second_idx] == cur_answer:
            second_cnt += 1
        if third[third_idx] == cur_answer:
            third_cnt += 1
            
    max_val = max(first_cnt, second_cnt, third_cnt)
    scores  = [first_cnt, second_cnt, third_cnt]
    answer = [i+1 for i, score in enumerate(scores) if score == max_val]

    return answer

