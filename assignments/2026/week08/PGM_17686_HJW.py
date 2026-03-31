# PGM 17686 - [3차] 파일명 정렬
# 유형: 정렬
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/17686

def solution(files):
    answer = []
    new_files = []
    for file in files:
        head = 0
        number = 0
        tail = 0
        for i in range(len(file)):
            if not head and file[i].isnumeric():
                head = i
            if head and not file[i].isnumeric():
                number = i
                break
        if not number:
            number = len(file)
        new_files.append([file[:head].lower(), file[:head], int(file[head:number]), file[head:number], file[number:]])
    
    new_files.sort(key=lambda x:(x[0], x[2]))
    for file in new_files:
        answer.append(file[1] + str(file[3]) + file[4])
    return answer