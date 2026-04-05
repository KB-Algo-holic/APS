# PGM 42587 - 프로세스
# 유형: 큐
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42587

def checkpriority(priorities):
    max = priorities[0]
    for i in range(len(priorities)):
        if max < priorities[i]:
            max = priorities[i]
    return max

def solution(priorities, location):
    answer = 0
    
    priority = checkpriority(priorities)
    while True:
        if priorities[0] >= priority:
            answer += 1
            if location == 0:
                break
            else:
                location -= 1
            del(priorities[0])
            priority = checkpriority(priorities)
        else:
            tmp = priorities[0]
            del(priorities[0])
            priorities.append(tmp)
            if location == 0:
                location = len(priorities) - 1
            else:
                location -= 1
    
    return answer