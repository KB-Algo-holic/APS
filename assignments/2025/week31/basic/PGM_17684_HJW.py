# PGM 17684 - [3차] 압축
# 유형: 해시
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/17684

dictionary = {}

def solution(msg):
    answer = []
    for i in range(1, 27):
        dictionary[chr(i+ord('A')-1)] = i
    start, step = 0, 1
    while True:
        
        if start+step > len(msg):
            answer.append(dictionary[msg[start:start+step-1]])
            break
        
        target = msg[start:start+step]
        if target in dictionary:
            step += 1
        
        else:
            dictionary[target] = len(dictionary)+1
            answer.append(dictionary[target[:-1]])
            start = start+step-1
            step = 1
            
    return answer