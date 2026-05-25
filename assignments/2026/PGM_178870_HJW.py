# PGM 178870 - 연속된 부분 수열의 합
# 유형: 누적합
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/178870

def solution(sequence, k):
    left = 0
    current_sum = 0
    
    answer = [0, len(sequence) - 1]
    min_length = len(sequence)

    for right in range(len(sequence)):
        current_sum += sequence[right]

        while current_sum > k:
            current_sum -= sequence[left]
            left += 1

        if current_sum == k:
            length = right - left

            if length < min_length:
                min_length = length
                answer = [left, right]

    return answer
