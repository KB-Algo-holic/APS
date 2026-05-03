# 5월 2주차 - 그래프 탐색 (DFS, BFS)

## 목표 🎯

그래프 탐색(Graph Traversal)은 코딩테스트에서 가장 자주 등장하는 핵심 알고리즘입니다.

대표 탐색 방법

- DFS (Depth First Search)
- BFS (Breadth First Search)

다음 문제 유형의 기반이 됩니다

- 연결 요소 찾기
- 최단 거리 문제
- 경로 탐색 문제
- 사이클 탐지
- 트리 탐색
- 완전탐색

이번 주차 목표

✔ DFS 구현 가능  
✔ BFS 구현 가능  
✔ 문제에 맞는 탐색 방법 선택 가능  
✔ 그래프 / 격자 탐색 문제 해결 가능

---

# 그래프 탐색이란

그래프 탐색은

```
모든 노드를 한 번씩 방문하는 과정
```

대표 방법

| 알고리즘 | 특징 |
|----------|------|
| DFS | 깊이 우선 탐색 |
| BFS | 너비 우선 탐색 |

---

# DFS (Depth First Search)

## 개념

가능한 한 **깊게 먼저 탐색**

예시

```
1 → 2 → 4 → 7
```

이후

```
되돌아가서 다른 경로 탐색
```

구현 방법

- 재귀
- 스택

---

# DFS 동작 원리

```
현재 노드 방문
→ 다음 노드 이동
→ 더 이상 이동 불가
→ 이전 노드 복귀
```

즉

```
Backtracking 구조
```

---

# DFS 구현 (재귀)

```java
void dfs(int node) {

    visited[node] = true;

    for (int next : graph.get(node)) {

        if (!visited[next]) {

            dfs(next);

        }

    }

}
```

---

# DFS 구현 (스택)

```java
Stack<Integer> stack = new Stack<>();

stack.push(start);

while (!stack.isEmpty()) {

    int node = stack.pop();

    if (!visited[node]) {

        visited[node] = true;

        for (int next : graph.get(node)) {

            stack.push(next);

        }

    }

}
```

---

# DFS 특징

장점

- 구현 쉬움
- 경로 탐색 문제에 강함
- 백트래킹 가능

사용 예시

```
모든 경로 탐색
조합 생성
사이클 탐지
```

---

# BFS (Breadth First Search)

## 개념

가까운 노드부터 먼저 탐색

예시

```
1 → 2 → 3 → 4 → 5
```

거리 순 탐색

---

# BFS 동작 원리

```
현재 노드 방문
→ 인접 노드 큐 삽입
→ 순서대로 탐색
```

Queue 사용

---

# BFS 구현

```java
Queue<Integer> queue = new LinkedList<>();

queue.offer(start);

visited[start] = true;

while (!queue.isEmpty()) {

    int node = queue.poll();

    for (int next : graph.get(node)) {

        if (!visited[next]) {

            visited[next] = true;

            queue.offer(next);

        }

    }

}
```

---

# BFS 특징

장점

- 최단거리 탐색 가능
- 레벨 단위 탐색 가능

사용 예시

```
최단 거리 문제
미로 탐색
네트워크 거리 계산
```

---

# DFS vs BFS 비교

| 항목 | DFS | BFS |
|------|-----|-----|
| 탐색 방식 | 깊이 우선 | 거리 우선 |
| 자료구조 | Stack | Queue |
| 구현 방식 | 재귀 가능 | 반복문 |
| 최단 거리 | 불가능 | 가능 |

---

# 언제 DFS 사용할까

이 표현 나오면 DFS 가능성 높음

```
모든 경우 탐색
경로 찾기
조합 생성
사이클 검사
트리 탐색
```

---

# 언제 BFS 사용할까

이 표현 나오면 BFS 가능성 높음

```
최단 거리
최소 이동 횟수
가장 빠른 경로
레벨 탐색
```

공식처럼 기억

```
최단거리 = BFS
```

---

# 방문 배열 (visited) 사용 이유

그래프는 사이클 존재 가능

예시

```
A → B → C → A
```

visited 없으면

```
무한 반복 발생
```

따라서 필수

```java
boolean[] visited = new boolean[n + 1];
```

---

# 그래프 입력 템플릿

```java
ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

for (int i = 0; i <= n; i++) {

    graph.add(new ArrayList<>());

}

for (int i = 0; i < m; i++) {

    int a = sc.nextInt();

    int b = sc.nextInt();

    graph.get(a).add(b);

    graph.get(b).add(a);

}
```

---

# 격자 탐색 (2차원 BFS / DFS)

코딩테스트 최빈출 유형

예시

```
미로 탐색
섬 개수
영역 개수
```

이동 방향

```java
int[] dx = {1, -1, 0, 0};

int[] dy = {0, 0, 1, -1};
```

---

# 2차원 BFS 템플릿

```java
Queue<int[]> queue = new LinkedList<>();

queue.offer(new int[]{x, y});

visited[x][y] = true;

while (!queue.isEmpty()) {

    int[] cur = queue.poll();

    for (int i = 0; i < 4; i++) {

        int nx = cur[0] + dx[i];

        int ny = cur[1] + dy[i];

        if (nx >= 0 && ny >= 0 &&
            nx < n && ny < m &&
            !visited[nx][ny]) {

            visited[nx][ny] = true;

            queue.offer(new int[]{nx, ny});

        }

    }

}
```

---

# 시간복잡도

DFS

```
O(V + E)
```

BFS

```
O(V + E)
```

격자 문제

```
O(N × M)
```

---

# 코딩테스트 꿀팁 💡

## 그래프 문제 = visited 필수

없으면 무한 루프 가능

---

## 최단거리 문제 = BFS

공식처럼 기억

---

## DFS 재귀 깊이 주의

노드 많으면

```
StackOverflow 발생 가능
```

이 경우

```
Stack 사용
```

추천

---

## 격자 문제 = 방향 배열 먼저 선언

```java
dx dy
```

습관화 추천

---

# 추천 연습 문제 🧪

## 프로그래머스

- 타겟 넘버
- 네트워크
- 게임 맵 최단거리

---

## 백준

- 1260 DFS와 BFS
- 2178 미로 탐색
- 2667 단지번호붙이기
- 1012 유기농 배추

---

# 이번 주 목표 ✅

✔ DFS 구현 가능  
✔ BFS 구현 가능  
✔ 그래프 탐색 문제 해결 가능  
✔ 격자 탐색 문제 해결 가능  
✔ 최단거리 문제 BFS 적용 가능