# PGM 72410 - 신규 아이디 추천
# 유형: 구현
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/72410

def solution(new_id):
    spc = ["-", "_", "."]
    answer = ""
    
    for digit in new_id:
        if ord("a") <= ord(digit) <= ord('z') or ord("0") <= ord(digit) <= ord("9"):
            answer += digit
        
        elif ord("A") <= ord(digit) <= ord("Z"):
            answer += digit.lower()
        
        elif digit in spc:
            answer += digit
    
    flag = 1
    while flag:
        for i in range(len(answer)-1):
            if answer[i] == "." and answer[i] == answer[i+1]:
                answer = answer[:i] + answer[i+1:]
                break
        else:
            flag = 0
            
    if answer and answer[0] == ".":
        answer = answer[1:]
    
    if answer and answer[-1] == ".":
        answer = answer[:-1]
    
    if not answer:
        answer += "a"
    
    if len(answer) >= 16:
        answer = answer[:15]
    
    if answer and answer[-1] == ".":
        answer = answer[:-1]
    
    if answer:
        while len(answer) <= 2:
            answer += answer[-1]
            
    return answer
