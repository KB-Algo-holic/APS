# PGM 42861 - 섬 연결하기
# 유형: 그리디
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42861

class Graph:
    def __init__(self, v):
        self.v = v
        self.edge = []
        self.parent = list(range(v+1))
        
    def add(self, a, b, w):
        self.edge.append((w, a, b))
        
    def find(self, v):
        if self.parent[v] == v:
            return v
        self.parent[v] = self.find(self.parent[v])
        return self.parent[v]
    
    def union(self, a, b):
        p1 = self.find(a)
        p2 = self.find(b)
        
        if p1 < p2:
            self.parent[p2] = p1
        else:
            self.parent[p1] = p2
            
    def kruskal(self):
        result = 0
        self.edge.sort()
        
        for w, a, b in self.edge:
            if self.find(a) != self.find(b):
                self.union(a, b)
                result += w
                
        return result

def solution(n, costs):
    answer = 0
    graph = Graph(n)
    for cost in costs:
        a, b, w = cost[0], cost[1], cost[2]
        graph.add(a, b, w)
    return graph.kruskal()