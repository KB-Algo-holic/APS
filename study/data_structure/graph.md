# 📘 그래프 (Graph)

## ✅ 개념 설명

그래프(Graph)는 **정점(Vertex)** 과 **간선(Edge)** 으로 구성된 **자료구조(Data Structure)** 로,
**데이터 간의 연결 관계(Relationship)** 를 표현하는 데 사용됩니다.

트리(Tree), 네트워크, SNS 팔로우 관계 등 **서로 연결된 구조**를 다룰 때 유용합니다.
즉, 그래프는 데이터를 “**어떻게 연결하느냐**”를 중심으로 설계된 구조입니다.

### 🔍 구조 이미지

> ![그래프 구조](https://upload.wikimedia.org/wikipedia/commons/5/5b/6n-graf.svg)
> *출처: 위키백과 (Graph Example)*

---

## 🧩 주요 구성 요소

| 구성 요소           | 설명                              |
| --------------- | ------------------------------- |
| **정점(Vertex)**  | 데이터를 담는 기본 단위 (예: 사람, 도시, 서버 등) |
| **간선(Edge)**    | 정점 간의 연결 관계                     |
| **가중치(Weight)** | 간선에 부여된 비용 또는 거리                |
| **차수(Degree)**  | 한 정점에 연결된 간선의 개수                |
| **경로(Path)**    | 한 정점에서 다른 정점으로 이동하는 간선들의 순서     |

---

## 🧮 그래프의 종류

| 종류           | 설명             | 예시           |
| ------------ | -------------- | ------------ |
| **무방향 그래프**  | 간선에 방향이 없는 그래프 | 친구 관계        |
| **방향 그래프**   | 간선에 방향이 있는 그래프 | 팔로우 관계       |
| **가중치 그래프**  | 간선마다 비용/거리 존재  | 지도, 네트워크     |
| **비가중치 그래프** | 모든 간선의 비용이 동일  | 단순 연결 관계     |
| **트리(Tree)** | 사이클이 없는 방향 그래프 | 조직도, 디렉터리 구조 |

---

## ⚙️ 표현 방식

그래프는 주로 **인접 리스트(Adjacency List)** 와 **인접 행렬(Adjacency Matrix)** 로 표현됩니다.

| 표현 방식      | 설명                     | 장점                 | 단점            |
| ---------- | ---------------------- | ------------------ | ------------- |
| **인접 리스트** | 각 정점별로 연결된 노드를 리스트로 저장 | 공간 효율적 (O(V+E))    | 연결 여부 확인 느림   |
| **인접 행렬**  | 2차원 배열로 연결 상태를 저장      | 연결 여부 확인 빠름 (O(1)) | 공간 낭비 (O(V²)) |

### 🧠 예시 (Python)

```python
# 인접 리스트
graph = {
    1: [2, 3],
    2: [1, 4],
    3: [1],
    4: [2]
}

# 인접 행렬
matrix = [
    [0, 1, 1, 0],
    [1, 0, 0, 1],
    [1, 0, 0, 0],
    [0, 1, 0, 0]
]
```

---

## ⏱️ 시간 복잡도

| 연산     | 인접 리스트 | 인접 행렬 |
| ------ | ------ | ----- |
| 정점 추가  | O(1)   | O(V²) |
| 간선 추가  | O(1)   | O(1)  |
| 간선 탐색  | O(V+E) | O(1)  |
| 공간 복잡도 | O(V+E) | O(V²) |

---

## 🧠 사용 예시

* **지도 탐색**: 도시 간 최단 경로, 내비게이션
* **SNS**: 친구/팔로우 관계 모델링
* **네트워크**: 서버 간 연결 구조 표현
* **웹 크롤링**: 페이지 간 링크 구조 분석
* **지식 그래프**: 개념 간 연관 관계 모델링

---

## 🧪 예제 코드

```python
# DFS (깊이 우선 탐색)
def dfs(graph, v, visited):
    visited.add(v)
    for nxt in graph[v]:
        if nxt not in visited:
            dfs(graph, nxt, visited)

graph = {
    1: [2, 3],
    2: [4],
    3: [],
    4: []
}
visited = set()
dfs(graph, 1, visited)
print("DFS 탐색 순서:", visited)
```

```java
// 인접 리스트 기반 그래프 생성
import java.util.*;

public class GraphExample {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= 4; i++) graph.add(new ArrayList<>());
        
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(2).add(4);
        
        System.out.println(graph);
    }
}
```

---

## 🧩 샘플 문제 (프로그래머스)

| 문제 이름   | 링크                                                                         |
| ------- | -------------------------------------------------------------------------- |
| 네트워크    | [🔗 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/43162) |
| 여행 경로   | [🔗 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/43164) |
| 섬 연결하기  | [🔗 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/42861) |
| 가장 먼 노드 | [🔗 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/49189) |

---

## 📎 정리

> 그래프는 데이터를 “연결” 중심으로 표현하는 **자료구조**이다.
> 그래프를 이해하면 탐색(DFS/BFS), 최단 경로, 네트워크 분석 등 다양한 **그래프 알고리즘**의 기반을 다질 수 있다.
