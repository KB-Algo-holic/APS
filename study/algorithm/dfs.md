# 📘 DFS (Depth-First Search)

## ✅ 개념 설명

DFS(깊이 우선 탐색)는 그래프 또는 트리에서 **최대한 깊게** 탐색한 뒤, 더 이상 갈 곳이 없으면 **되돌아가면서** 탐색하는 방식입니다.  
스택(LIFO) 구조나 재귀함수를 통해 구현할 수 있습니다.

### 🔍 구조 이미지
> ![DFS 구조](https://upload.wikimedia.org/wikipedia/commons/7/7f/Depth-First-Search.gif)
> *출처: 위키백과*

---

## 🧮 주요 특징

| 항목      | 설명                                  |
|-----------|---------------------------------------|
| 자료구조   | 스택 또는 재귀 호출                   |
| 방문 순서 | 한 방향으로 가능한 한 깊이 탐색        |
| 구현 방식 | 재귀 또는 명시적 스택 사용             |
| 공간 복잡도 | O(V) (V: 정점 수)                    |

---

## ⚙️ 시간 복잡도

| 입력 유형       | 시간 복잡도       |
|------------------|--------------------|
| 인접 리스트(Graph) | O(V + E)           |
| 인접 행렬(Matrix) | O(V²)              |

---

## 🧠 사용 예시
- 미로 탐색
- 사이클 검출
- 조합/순열 탐색 (백트래킹)
- 연결 요소(Connected Component) 탐색

---

## 🧪 예제 코드 (Python)

```python
def dfs(graph, v, visited):
    visited[v] = True
    print(v, end=' ')
    for next_v in graph[v]:
        if not visited[next_v]:
            dfs(graph, next_v, visited)

# 예시 그래프
graph = {
    1: [2, 3, 4],
    2: [5],
    3: [],
    4: [],
    5: []
}
visited = [False] * 6
dfs(graph, 1, visited)
```

## 🧩 샘플 문제 (프로그래머스)
| 문제 이름           | 링크                                                                         |
|----------------------|------------------------------------------------------------------------------|
| 타겟 넘버             | [🔗 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/43165) |
| 네트워크              | [🔗 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/43162) |
| 여행경로              | [🔗 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/4316) |