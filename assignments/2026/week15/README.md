# 5월 3주차 - Disjoint Set (Union-Find)

## 목표 🎯

Disjoint Set (서로소 집합, Union-Find)은

```
집합의 연결 여부를 매우 빠르게 판별하는 자료구조
```

입니다.

대표 사용 목적

- 같은 그룹인지 판별
- 연결 여부 확인
- 사이클 판별
- 네트워크 연결
- 최소 신장 트리(MST)

특히 다음 알고리즘의 핵심입니다

- Kruskal MST
- Connected Component
- Graph Cycle Detection

이번 주차 목표

✔ Union-Find 개념 이해  
✔ Union / Find 구현 가능  
✔ Path Compression 이해  
✔ 그래프 사이클 판별 가능  
✔ MST 준비 완료

---

# 서로소 집합 (Disjoint Set)이란

서로 공통 원소가 없는 집합

예시

```
{1, 2, 3}

{4, 5}

{6}
```

특징

```
집합 간 겹치는 원소 없음
```

---

# Union-Find란

Disjoint Set을 효율적으로 관리하는 알고리즘

핵심 기능

| 기능 | 설명 |
|------|------|
| Find | 부모 찾기 |
| Union | 집합 합치기 |

---

# 왜 필요한가 🤔

예시

```
1과 3이 연결되어 있는가?
```

일반 탐색

```
DFS / BFS → O(N)
```

Union-Find

```
거의 O(1)
```

매우 빠름

---

# 기본 개념

각 노드는

```
부모(parent)
```

를 가짐

처음에는

```
자기 자신이 부모
```

예시

초기 상태

```
1 2 3 4 5

parent

1 2 3 4 5
```

---

# Union 동작 원리

예시

```
Union(1, 2)
```

의미

```
1과 2를 같은 그룹으로 합침
```

결과

```text
1
└── 2
```

parent

```text
1 1 3 4 5
```

---

# Find 동작 원리

예시

```text
1
└── 2
```

Find(2)

결과

```
1
```

즉

```
최상위 부모(root) 반환
```

---

# Java 구현 (핵심 템플릿)

## 부모 배열 선언

```java
int[] parent = new int[n + 1];
```

---

## 초기화

자기 자신이 부모

```java
for (int i = 1; i <= n; i++) {

    parent[i] = i;

}
```

---

# Find 구현

부모 찾기

```java
static int find(int x) {

    if (parent[x] == x) {

        return x;

    }

    return find(parent[x]);

}
```

---

# Union 구현

집합 합치기

```java
static void union(int a, int b) {

    int rootA = find(a);

    int rootB = find(b);

    if (rootA != rootB) {

        parent[rootB] = rootA;

    }

}
```

---

# 연결 여부 확인

같은 그룹인지 확인

```java
if (find(a) == find(b))
```

같은 부모면

```
같은 집합
```

---

# Path Compression ⭐

Union-Find 핵심 최적화

문제점

트리가 길어질 수 있음

예시

```text
1
└── 2
     └── 3
          └── 4
```

Find 느려짐

---

## Path Compression 적용

부모를 바로 root로 변경

```java
static int find(int x) {

    if (parent[x] == x) {

        return x;

    }

    return parent[x] =
        find(parent[x]);

}
```

효과

```text
1
├── 2
├── 3
└── 4
```

탐색 속도 매우 빨라짐

---

# 시간복잡도

기본

```
O(N)
```

Path Compression 적용

```
거의 O(1)
```

정확히는

```text
O(α(N))
```

(아커만 역함수)

실질적으로 상수 시간

---

# 사이클 판별 🚨

그래프 문제 핵심

원리

간선 연결 시

```
이미 같은 부모면
사이클 발생
```

예시

```java
if (find(a) == find(b)) {

    cycle = true;

} else {

    union(a, b);

}
```

---

# 최소 신장 트리 (Kruskal)

Union-Find 대표 활용

흐름

1️⃣ 간선 정렬

2️⃣ 사이클 검사

3️⃣ 연결 가능하면 Union

예시

```java
if (find(a) != find(b)) {

    union(a, b);

}
```

---

# 문제 판별 힌트 🔍

이 표현 나오면

```
Union-Find 의심
```

대표 키워드

```text
연결 여부
같은 그룹
친구 관계
네트워크
집합 합치기
사이클 판별
```

---

# DFS/BFS vs Union-Find

| 항목 | DFS/BFS | Union-Find |
|------|----------|------------|
| 연결 판별 | 가능 | 매우 빠름 |
| 최단 거리 | 가능 | 불가능 |
| 사이클 판별 | 가능 | 매우 강함 |

---

# 코딩테스트 꿀팁 💡

## Union-Find = parent 배열

거의 공식처럼 사용

```java
parent[]
```

---

## Find에 Path Compression 필수

코딩테스트에서는 거의 항상 적용

---

## 그래프 사이클 문제 나오면 의심

대표 표현

```text
순환
사이클
연결
```

---

## MST 나오면 거의 무조건 사용

```
Kruskal + Union-Find
```

세트처럼 기억

---

# 추천 연습 문제 🧪

## 프로그래머스

- 섬 연결하기

---

## 백준

- 1717 집합의 표현
- 1976 여행 가자
- 20040 사이클 게임

---

# 이번 주 목표 ✅

✔ Union-Find 구현 가능  
✔ Path Compression 이해  
✔ 연결 여부 판별 가능  
✔ 사이클 탐지 가능  
✔ Kruskal 준비 완료