# 4월 4주차 - 트리 (Tree)

## 목표

트리(Tree)는 계층 구조를 표현하는 대표적인 자료구조입니다.

특히 다음 알고리즘의 기반이 됩니다

- DFS
- BFS
- 이진 탐색 트리 (BST)
- 힙 (Heap)
- 최소 신장 트리
- 세그먼트 트리
- 트라이 (Trie)

이번 주차 목표

✔ 트리 개념 이해  
✔ 이진트리 구조 이해  
✔ 트리 순회 구현 가능  
✔ BST 개념 이해  
✔ Heap 구조 이해

---

# 트리(Tree)란

트리는 **노드(Node)** 와 **간선(Edge)** 으로 이루어진 계층형 자료구조입니다.

예시

```
        A
       / \
      B   C
     / \
    D   E
```

특징

- 사이클 없음
- 부모 노드 존재
- 계층 구조 표현 가능

대표 사용 예시

- 조직도
- 파일 시스템
- HTML DOM 구조
- 네트워크 구조

---

# 트리 기본 용어

| 용어 | 설명 |
|------|------|
| Node | 트리를 구성하는 요소 |
| Edge | 노드를 연결하는 선 |
| Root | 가장 위 노드 |
| Parent | 부모 노드 |
| Child | 자식 노드 |
| Leaf | 자식 없는 노드 |
| Depth | 루트부터의 거리 |
| Height | 가장 긴 경로 길이 |
| Level | 같은 Depth 노드 집합 |

예시

```
Depth(root) = 0
Depth(child) = 1
```

---

# 트리 특징

트리는 그래프의 한 종류입니다.

하지만 다음 조건을 만족합니다

```
간선 개수 = 노드 개수 - 1
```

그리고

```
사이클 없음
```

---

# 이진 트리 (Binary Tree)

각 노드가 최대 두 개의 자식을 가지는 트리

구조

```
        A
       / \
      B   C
```

구성

```
Left child
Right child
```

---

# 이진 트리 종류

## 포화 이진 트리 (Full Binary Tree)

모든 노드가 2개의 자식을 가짐

예시

```
        A
       / \
      B   C
     / \ / \
    D  E F  G
```

---

## 완전 이진 트리 (Complete Binary Tree)

왼쪽부터 차례대로 채워진 트리

예시

```
        A
       / \
      B   C
     / \
    D   E
```

Heap 구조에서 사용

---

## 편향 트리 (Skewed Tree)

한쪽으로만 치우친 트리

예시

```
A
 \
  B
   \
    C
```

---

# 이진 탐색 트리 (BST)

Binary Search Tree

특징

```
왼쪽 < 부모 < 오른쪽
```

예시

```
        10
       /  \
      5    15
```

탐색 시간복잡도

```
O(log N)
```

최악의 경우

```
O(N)
```

(편향 트리)

---

# BST 탐색

예시

값 7 탐색

```
7 < 10 → 왼쪽 이동
7 > 5 → 오른쪽 이동
```

이 방식으로 탐색

---

# 트리 구현 방법

## Node 클래스 구현

```java
class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
    }
}
```

---

# 트리 순회 (Tree Traversal)

트리를 방문하는 방법

대표 4가지 존재

| 순회 방식 | 특징 |
|----------|------|
| 전위 순회 | Root 먼저 |
| 중위 순회 | Root 중간 |
| 후위 순회 | Root 마지막 |
| 레벨 순회 | BFS 기반 |

---

# 전위 순회 (Preorder)

순서

```
Root → Left → Right
```

구현

```java
void preorder(Node node) {
    if (node == null) return;

    System.out.println(node.value);
    preorder(node.left);
    preorder(node.right);
}
```

---

# 중위 순회 (Inorder)

순서

```
Left → Root → Right
```

BST에서 사용 시

```
정렬된 결과 출력
```

구현

```java
void inorder(Node node) {
    if (node == null) return;

    inorder(node.left);
    System.out.println(node.value);
    inorder(node.right);
}
```

---

# 후위 순회 (Postorder)

순서

```
Left → Right → Root
```

구현

```java
void postorder(Node node) {
    if (node == null) return;

    postorder(node.left);
    postorder(node.right);
    System.out.println(node.value);
}
```

---

# 레벨 순회 (Level Order)

BFS 방식

Queue 사용

```java
Queue<Node> queue = new LinkedList<>();
```

구현

```java
queue.offer(root);

while (!queue.isEmpty()) {
    Node cur = queue.poll();

    if (cur.left != null)
        queue.offer(cur.left);

    if (cur.right != null)
        queue.offer(cur.right);
}
```

---

# Heap (힙)

완전 이진 트리 기반 자료구조

종류

| 종류 | 특징 |
|------|------|
| 최소 힙 | 부모 ≤ 자식 |
| 최대 힙 | 부모 ≥ 자식 |

예시

```
PriorityQueue
```

사용

---

# Java Heap 사용

최소 힙

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
```

최대 힙

```java
PriorityQueue<Integer> pq =
    new PriorityQueue<>(Collections.reverseOrder());
```

---

# 트리 문제 판별 방법

이 표현 나오면 트리 문제 가능성 높음

```
부모
자식
루트
깊이
높이
경로
```

또는

```
계층 구조
```

---

# 코딩테스트 꿀팁

## 중위 순회 = 정렬 결과

BST 문제에서 매우 중요

---

## 트리 문제 = DFS 또는 BFS

대부분 아래 방식 사용

```
재귀
스택
큐
```

---

## 완전 이진 트리 나오면 Heap 의심

예시

```
우선순위 문제
최솟값
최댓값
```

---

# 시간복잡도

트리 탐색

```
O(N)
```

BST 탐색

평균

```
O(log N)
```

최악

```
O(N)
```

---

# 추천 연습 문제

## 프로그래머스

- 타겟 넘버
- 네트워크

---

## 백준

- 1991 트리 순회
- 11725 트리의 부모 찾기
- 5639 이진 검색 트리

---

# 이번 주 목표

✔ 트리 기본 개념 이해  
✔ 이진트리 구조 이해  
✔ 전위 / 중위 / 후위 순회 구현 가능  
✔ BFS 레벨 순회 이해  
✔ BST 탐색 원리 이해