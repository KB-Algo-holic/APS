# PGM 84512 - 모음사전
# 유형: 완전탐색
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/84512

wordList = ["A", "E", "I", "O", "U"]
dic = dict()
cnt = 0

def dfs(word):
    
    global cnt
    
    if len(word) == 6:
        return
    
    dic[word] = cnt
    cnt += 1
    
    for i in range(5):
        dfs(word+wordList[i])

def solution(word):
    
    dfs("")
    return dic.get(word)