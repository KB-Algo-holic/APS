# PGM 12946 - 하노이의 탑
# 유형: 재귀
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12946

def hanoi(n):
    
    if n == 1:
        return [["1", "3"]]
    
    tmp1 = hanoi(n-1)
    tmp2 = hanoi(n-1)
        
    for i in range(len(tmp1)):
        for j in range(2):
            if tmp1[i][j] == "2":
                tmp1[i][j] = "3"
            elif tmp1[i][j] == "3":
                tmp1[i][j] = "2"
        
    for i in range(len(tmp2)):
        for j in range(2):
            if tmp2[i][j] == "1":
                tmp2[i][j] = "2"
            elif tmp2[i][j] == "2":
                tmp2[i][j] = "1"
        
    return tmp1 + [["1", "3"]] + tmp2
    
def solution(n):
    answer = hanoi(n)
    for i in range(len(answer)):
        for j in range(2):
            answer[i][j] = int(answer[i][j])
    
    return answer