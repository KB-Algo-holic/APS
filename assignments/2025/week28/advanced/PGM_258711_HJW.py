# PGM 258711 - 도넛과 막대 그래프
# 유형: 구현 / DFS
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/258711

def visit_donut(start, visited, outs):
    
    visited[start] = 1
    node = outs[start][0]

    while True:
        visited[node] = 1
        node = outs[node][0]
        if node == start:
            break

def visit_stick(start, visited, outs):
    
    if not outs[start]:
        visited[start] = 1
        return
    
    visited[start] = 1
    node = outs[start][0]
    while True:
        visited[node] = 1
        if not outs.get(node):
            break
        node = outs[node][0]
        
def visit_eight(center, visited, outs):

    node = outs[center][0]
    while True:
        if node == center:
            break
        visited[node] = 1
        node = outs[node][0]
    
    node = outs[center][1]
    while True:
        if node == center:
            break
        visited[node] = 1
        node = outs[node][0]
    
    visited[center] = 1
        
def solution(edges):
    ins, outs = dict(), dict()
    nodes = set()
    for edge in edges:
        a, b = edge[0], edge[1]
        nodes.add(a)
        nodes.add(b)
        
        if ins.get(b):
            ins[b].append(a)
        else:
            ins[b] = [a]
        
        if outs.get(a):
            outs[a].append(b)
        else:
            outs[a] = [b]
    
    for i in nodes:
        if not ins.get(i):
            ins[i] = []
        if not outs.get(i):
            outs[i] = []
    
    center = 0
    for i in nodes:
        if len(outs[i]) >= 2 and not ins.get(i):
            center = i
            break
    
    ins, outs = dict(), dict()
    for edge in edges:
        a, b = edge[0], edge[1]
        if a == center:
            continue
        
        if ins.get(b):
            ins[b].append(a)
        else:
            ins[b] = [a]
        
        if outs.get(a):
            outs[a].append(b)
        else:
            outs[a] = [b]
    
    visited = dict()
    for i in nodes:
        if i != center:
            if not ins.get(i):
                ins[i] = []
            if not outs.get(i):
                outs[i] = []
            visited[i] = 0

            
    d, s, e = 0, 0, 0
    for i in nodes:
        if i != center and not visited[i]:
            if not ins.get(i):
                visit_stick(i, visited, outs)
                s += 1
            elif len(ins[i]) == 2 and len(outs[i]) == 2:
                visit_eight(i, visited, outs)
                e += 1
    
    for i in nodes:
        if i != center and not visited[i]:
            if len(ins[i]) == 1 and len(outs[i]) == 1:
                visit_donut(i, visited, outs)
                d += 1
    
    return [center, d, s, e]