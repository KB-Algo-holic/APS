# PGM 161988 - 연속 펄스 부분 수열의 합
# 유형: DP
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/161988

def solution(sequence):
    answer = 0
    N = len(sequence)
    first_seq = []
    second_seq = []
    for i in range(N):
        first_seq.append(sequence[i] if not i%2 else -sequence[i])
        second_seq.append(sequence[i] if i%2 else -sequence[i])
    
    first_DP = [0] * N
    second_DP = [0] * N
    first_DP[0] = first_seq[0]
    second_DP[0] = second_seq[0]
    
    for i in range(N-1):
        first_DP[i+1] = first_DP[i] + first_seq[i+1] if first_DP[i] + first_seq[i+1] > first_seq[i+1] else first_seq[i+1]
        second_DP[i+1] = second_DP[i] + second_seq[i+1] if second_DP[i] + second_seq[i+1] > second_seq[i+1] else second_seq[i+1]
    
    answer = -300000
    for i in range(N):
        if first_DP[i] > answer:
            answer = first_DP[i]
        if second_DP[i] > answer:
            answer = second_DP[i]
            
    return answer