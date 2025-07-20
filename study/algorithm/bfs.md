# 📘 BFS (Breadth-First Search)

## ✅ 개념 설명

BFS(너비 우선 탐색)는 그래프나 트리에서 **가까운 정점부터** 탐색해 나가는 방식입니다.  
**큐(FIFO)** 자료구조를 사용하여 탐색 순서를 제어합니다.

### 🔍 구조 이미지
> ![BFS 구조](https://upload.wikimedia.org/wikipedia/commons/5/5d/Breadth-First-Search-Algorithm.gif)
> *출처: 위키백과*

---

## 🧮 주요 특징

| 항목      | 설명                                 |
|-----------|--------------------------------------|
| 자료구조   | 큐                                   |
| 방문 순서 | 가까운 노드부터 탐색 (레벨 순서)      |
| 구현 방식 | while 루프 + 큐                      |
| 공간 복잡도 | O(V)                                |

---

## ⚙️ 시간 복잡도

| 입력 유형       | 시간 복잡도       |
|------------------|--------------------|
| 인접 리스트(Graph) | O(V + E)           |
| 인접 행렬(Matrix) | O(V²)              |

---

## 🧠 사용 예시
- 최단 거리 탐색
- 레벨 탐색
- 최단 경로 (가중치 없는 그래프)
- Flood Fill

---

## 🧪 예제 코드 (Python)

```python
from collections import deque

def bfs(graph, start):
    visited = set()
    queue = deque([start])
    visited.add(start)
    
    while queue:
        v = queue.popleft()
        print(v, end=' ')
        for next_v in graph[v]:
            if next_v not in visited:
                visited.add(next_v)
                queue.append(next_v)

# 예시 그래프
graph = {
    1: [2, 3],
    2: [4, 5],
    3: [],
    4: [],
    5: []
}
bfs(graph, 1)
```

## 🧩 샘플 문제 (프로그래머스)
| 문제 이름           | 링크                                                                         |
|----------------------|------------------------------------------------------------------------------|
| 게임 맵 최단거리       | [🔗 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/1844) |
| 네트워크              | [🔗 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/43162) |