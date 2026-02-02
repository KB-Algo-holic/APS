# PGM 1845 - 폰켓몬
# 유형: 해시
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/1845

def solution(nums):
    answer = 0
    N = len(nums) // 2
    nums = set(nums)
    answer = len(nums) if N > len(nums) else N
    return answer