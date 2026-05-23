# PGM 178870 - 연속된 부분 수열의 합
# 유형: 누적합
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/178870

def solution(sequence, k):
    answer = []
    summation = [0] * len(sequence)
    summation[0] = sequence[0]
    for i in range(1, len(sequence)):
        summation[i] = summation[i-1] + sequence[i]
    summation = [0] + summation
    head, tail = 0, 1
    while tail <= len(sequence):
        tmp = summation[tail] - summation[head]
        if tmp == k:
            answer.append([head,tail-1, head-tail])
            head += 1
            tail += 1
        elif tmp < k:
            tail += 1
        elif tmp > k:
            head += 1

    answer.sort(key=lambda x:x[2], reverse=True)
    answer[0].pop()
    return answer[0]