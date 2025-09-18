# PGM 92342 - 양궁대회
# 유형: 구현 / 탐색
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/92342

Max = -1
answer_list = []

def get_score(ap, ry):
    appeach, ryan = 0, 0
    for i in range(10):
        if ap[i] and ap[i] >= ry[i]:
            appeach += 10-i
        elif ry[i] and ry[i] > ap[i]:
            ryan += 10-i
    
    return appeach, ryan

def dfs(info, ry, step, rest, n):
    
    global Max, answer_list
    
    if step >= 11:
        if sum(ry) < n:
            return
        appeach, ryan = get_score(info, ry)
        if ryan > appeach:
            if ryan-appeach > Max:
                Max = ryan - appeach
                answer_list = []
                answer_list.append(ry[::])
            if ryan - appeach == Max:
                answer_list.append(ry[::])
        return
    
    for i in range(rest+1):
        ry[step] = i
        dfs(info, ry, step+1, rest-i, n)

def solution(n, info):
    ry = [0] * 11
    dfs(info, ry, 0, n, n)
    global answer_list
    answer_list.sort(key=lambda x:x[::-1], reverse=True)
    if answer_list:
        answer = answer_list[0]
    else:
        answer = [-1]
    
    return answer