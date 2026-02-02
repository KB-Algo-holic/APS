# PGM 17681 - [1차] 비밀지도
# 유형: 구현
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/17681

def num_to_binary(n, arr):
    
    result = []
    
    for num in arr:
        binary = bin(num)[2:].zfill(n)
        result.append(binary)
    
    return result

def merge(n, bin1, bin2):
    
    result = []
    
    for i in range(n):
        line = ""
        for j in range(n):
            if bin1[i][j] == "1" or bin2[i][j] == "1":
                line += "#"
            else:
                line += " "
        result.append(line)
    
    return result

def solution(n, arr1, arr2):
    
    answer = []
    bin1 = num_to_binary(n, arr1)
    bin2 = num_to_binary(n, arr2)
    answer = merge(n, bin1, bin2)
    
    return answer