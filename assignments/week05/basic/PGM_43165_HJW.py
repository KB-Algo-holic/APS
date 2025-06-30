# PGM 43165 - 타겟 넘버
# 유형: DFS
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43165

answer = 0

def dfs(numbers, idx, total, target):
    
    global answer
    
    if idx == len(numbers):
        if total == target:
            answer += 1
        return
    
    dfs(numbers, idx+1, total+numbers[idx], target)
    dfs(numbers, idx+1, total-numbers[idx], target)

def solution(numbers, target):
    
    dfs(numbers, 0, 0, target)
    return answer
    