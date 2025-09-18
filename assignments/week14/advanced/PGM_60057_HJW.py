# PGM 60057 - 문자열 압축
# 유형: 문자열
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/60057

def solution(s): 
    answer = len(s) 
    length = len(s)
    for i in range(1, length+1):
        result = ""
        u = 0
        while u < length:
            if u+i <= length:
                target = s[u:u+i]
                count = 1
                while True:
                    if u+(count+1)*i <= length and target == s[u+count*i:u+(count+1)*i]:
                        count += 1
                    else:
                        break
                if count > 1:
                    result += str(count)+target
                else:
                    result += target
                u = u+count*i
            else:
                result += s[u:]
                break
        if len(result) < answer:
            answer = len(result)
            
    return answer