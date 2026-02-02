# PGM 72412 - 순위 검색
# 유형: 이분탐색/DFS
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/72412

answer = []

def count(arr, x):
    
    start, end = 0, len(arr)
    
    while start < end:
        mid = (start + end) // 2
        
        if x <= arr[mid]:
            end = mid
        
        else:
            start = mid+1
    
    return start

def dfs(idx, step, query, dic):
    
    global answer
    
    if step == 3:
        if query[3] == "-":
            for key in dic:
                answer[idx] += len(dic[key]) - count(dic[key], int(query[4]))

        else:
            answer[idx] += len(dic[query[3]]) - count(dic[query[3]], int(query[4]))

        return
    
    if query[step] == "-":
        for key in dic:
            dfs(idx, step+1, query, dic[key])
    else:
        dfs(idx, step+1, query, dic[query[step]])
        

def solution(info, query):
    
    global answer
    answer = [0] * len(query)
    
    table = {}
    table["java"] = {}
    table["cpp"] = {}
    table["python"] = {}
    for lang in table:
        table[lang]["backend"] = {}
        table[lang]["frontend"] = {}
    for lang in table:
        for posi in table[lang]:
            table[lang][posi]["junior"] = {}
            table[lang][posi]["senior"] = {}
    for lang in table:
        for posi in table[lang]:
            for career in table[lang][posi]:
                table[lang][posi][career]["chicken"] = []
                table[lang][posi][career]["pizza"] = []
    
    for i in info:
        lang, posi, career, food, score = map(str, i.split())
        table[lang][posi][career][food].append(int(score))
    
    for lang in table:
        for posi in table[lang]:
            for career in table[lang][posi]:
                for food in table[lang][posi][career]:
                    table[lang][posi][career][food].sort()
        
    for i in range(len(query)):
        lang, posi, career, food_score = map(str, query[i].split("and"))
        food, score = map(str, food_score.split())
        lang, posi, career = lang.strip(), posi.strip(), career.strip()
        dfs(i, 0, [lang, posi, career, food, score], table)
    return answer