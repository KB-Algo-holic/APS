# PGM 155652 - 둘만의 암호
# 유형: 해시
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/155652

def solution(s, skip, index):
    answer = ''
    
    alphabet = []
    for i in range(26):
        target = chr(i + ord('a'))
        if not target in skip:
            alphabet.append(target)
    
    N = len(alphabet)
    dic = dict()
    dic_ = dict()
    for i in range(N):
        dic[alphabet[i]] = i
        dic_[i] = alphabet[i]
    
    for char in s:
        idx = dic[char]
        tmp = (idx + index) % N
        answer += dic_[tmp]
    
    return answer