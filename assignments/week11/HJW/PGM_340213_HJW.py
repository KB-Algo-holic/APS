# PGM 340213 - 동영상 재생기
# 유형: 문자열 
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/340213

def mintosec(m):
    splited = list(map(int, m.split(':')))
    return splited[0] * 60 + splited[1]

def sectomin(s):
    return str(s//60).zfill(2) + ':' + str(s%60).zfill(2)

def solution(video_len, pos, op_start, op_end, commands):
    answer = mintosec(pos)
    video_len = mintosec(video_len)
    op_start = mintosec(op_start)
    op_end = mintosec(op_end)
    
    if op_start <= answer <= op_end:
        answer = op_end
    
    for command in commands:
        if command == 'next':
            answer = min(answer+10, video_len)
        elif command == 'prev':
            answer = max(answer-10, 0)
        
        if op_start <= answer <= op_end:
            answer = op_end
    
    return sectomin(answer)