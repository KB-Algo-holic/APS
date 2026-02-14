# PGM 17677 - [1차] 뉴스 클러스터링
# 유형: 해시
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/17677

def solution(str1, str2):
    answer = 0
    dict1 = {}
    dict2 = {}
    
    for i in range(len(str1)-1):
        if ord('a') <= ord(str1[i].lower()) <= ord('z') and ord('a') <= ord(str1[i+1].lower()) <= ord('z'):
            dict1[str1[i:i+2].lower()] = dict1.get(str1[i:i+2].lower(), 0) + 1
    for i in range(len(str2)-1):
        if ord('a') <= ord(str2[i].lower()) <= ord('z') and ord('a') <= ord(str2[i+1].lower()) <= ord('z'):
            dict2[str2[i:i+2].lower()] = dict2.get(str2[i:i+2].lower(), 0) + 1
    
    union = {}
    intersec = {}
    
    for char1 in dict1:
        union[char1] = dict1[char1]
    
    for char2 in dict2:
        if char2 in union:
            union[char2] = max(union[char2], dict2[char2])
        else:
            union[char2] = dict2[char2]
    
    for char1 in dict1:
        for char2 in dict2:
            if char1 == char2:
                intersec[char1] = min(dict1[char1], dict2[char1])
    union_sum = 0
    intersec_sum = 0
    
    for un in union:
        union_sum += union[un]
    for inter in intersec:
        intersec_sum += intersec[inter]
    
    if union_sum == 0:
        answer = 65536
    else:
        answer = int((intersec_sum / union_sum) * 65536)
    return answer