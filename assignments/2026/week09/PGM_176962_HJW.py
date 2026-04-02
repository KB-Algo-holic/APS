# PGM 176962 - 과제 진행하기
# 유형: 스택
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/176962

def solution(plans):
    answer = []
    
    for i in range(len(plans)):
        tmp = plans[i][1].split(":")
        plans[i][1] = int(tmp[0]) * 60 + int(tmp[1])
        plans[i][2] = int(plans[i][2])
    
    plans.sort(key=lambda x:x[1], reverse = True)
    
    stack1 = []
    for plan in plans:
        stack1.append(plan)
    
    stack2 = []
    target = []
    time = 0
    while stack1:
        if stack1[-1][1] == time:
            stack2.append(stack1.pop())

        if stack2:
            stack2[-1][2] -= 1

            if stack2[-1][2] == 0:
                answer.append(stack2.pop()[0])
        
        time += 1
        
    while stack2:
        answer.append(stack2.pop()[0])
    
    return answer