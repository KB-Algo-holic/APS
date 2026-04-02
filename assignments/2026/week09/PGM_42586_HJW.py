# PGM 42586 - 기능개발
# 유형: 큐
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42586

def solution(progresses, speeds):
    
    front = 0
    end = len(speeds)
    answer = []
    
    while True:
        tmp = 0
        for i in range(end):
            progresses[i] += speeds[i]
        for i in range(front, end):
            if progresses[i] >= 100:
                tmp += 1
                front += 1
            else:
                break
        if tmp != 0:
            answer.append(tmp)
        if front == end:
            break
    
    return answer