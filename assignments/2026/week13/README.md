# 5월 1주차 - 우선순위 큐 (Priority Queue)

## 목표 🎯

우선순위 큐(Priority Queue)는 **우선순위가 높은 데이터부터 먼저 처리되는 자료구조**입니다.

일반 Queue와 달리

```
먼저 들어온 데이터가 아니라
우선순위가 높은 데이터가 먼저 나온다
```

다음 알고리즘에서 매우 중요합니다

- Heap
- 다익스트라
- 그리디
- 스케줄링 문제
- Top-K 문제

이번 주차 목표

✔ 우선순위 큐 개념 이해  
✔ 최소 힙 / 최대 힙 이해  
✔ Comparator 정렬 구현 가능  
✔ 문제에 맞는 우선순위 설계 가능

---

# 우선순위 큐란 📦

일반 Queue

```
FIFO
First In First Out
```

Priority Queue

```
우선순위 높은 데이터 먼저 처리
```

예시

입력

```
3, 1, 5, 2
```

출력

```
1, 2, 3, 5
```

(최소 힙 기준)

---

# Heap과의 관계 🌳

우선순위 큐는 보통 **Heap 구조**로 구현됩니다.

Heap 특징

```
완전 이진 트리 기반
```

종류

| 구조 | 특징 |
|------|------|
| 최소 힙 | 부모 ≤ 자식 |
| 최대 힙 | 부모 ≥ 자식 |

---

# 최소 힙 (Min Heap)

가장 작은 값이 먼저 나옴

예시

```
입력: 4 2 7 1
출력: 1 2 4 7
```

---

# 최대 힙 (Max Heap)

가장 큰 값이 먼저 나옴

예시

```
입력: 4 2 7 1
출력: 7 4 2 1
```

---

# Java PriorityQueue 사용법 ☕

## 선언 (최소 힙)

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
```

자동으로 오름차순 정렬됨

---

## 데이터 삽입

```java
pq.offer(3);
pq.offer(1);
pq.offer(5);
```

---

## 데이터 제거

```java
pq.poll();
```

가장 작은 값 반환

---

## 데이터 조회

```java
pq.peek();
```

제거하지 않고 확인만 수행

---

# 최대 힙 구현 🔄

```java
PriorityQueue<Integer> pq =
    new PriorityQueue<>(Collections.reverseOrder());
```

---

# Comparator 직접 정의 ✍️

사용자 정의 정렬 가능

예시

절댓값 기준 정렬

```java
PriorityQueue<Integer> pq =
    new PriorityQueue<>((a, b) ->
        Math.abs(a) - Math.abs(b)
    );
```

---

# 다중 조건 정렬

예시

1️⃣ 절댓값 기준 정렬  
2️⃣ 같으면 작은 값 우선

```java
PriorityQueue<Integer> pq =
    new PriorityQueue<>((a, b) -> {
        if (Math.abs(a) == Math.abs(b))
            return a - b;

        return Math.abs(a) - Math.abs(b);
    });
```

---

# 객체 정렬 (중요) 🧠

코딩테스트에서 매우 자주 등장

예시

노드 + 거리 저장

```java
class Node {
    int node;
    int cost;

    Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}
```

정렬 기준

```java
PriorityQueue<Node> pq =
    new PriorityQueue<>((a, b) ->
        a.cost - b.cost
    );
```

다익스트라 기본 패턴

---

# 우선순위 큐 내부 동작 원리 ⚙️

PriorityQueue는 내부적으로

```
Heap 구조
```

사용

시간복잡도

| 연산 | 시간복잡도 |
|------|------------|
| 삽입 | O(log N) |
| 삭제 | O(log N) |
| 조회 | O(1) |

---

# 일반 Queue vs PriorityQueue 비교

| 자료구조 | 기준 |
|----------|------|
| Queue | 입력 순서 |
| PriorityQueue | 우선순위 |

---

# 코딩테스트 핵심 활용 패턴 🚀

## Top-K 문제

예시

```
가장 작은 값 K개 찾기
가장 큰 값 K개 찾기
```

---

## 다익스트라 알고리즘

최단 거리 문제

```java
PriorityQueue<Node>
```

필수 사용

---

## 스케줄링 문제

예시

```
작업 처리 순서
회의실 배정
프로세스 실행
```

---

## 정렬 대체 용도

전체 정렬 대신 사용 가능

```
N log K
```

시간 절약 가능

---

# PriorityQueue vs 정렬 비교 📊

| 방법 | 시간복잡도 |
|------|------------|
| 정렬 | O(N log N) |
| PQ 사용 | O(N log K) |

Top-K 문제에서 PQ 유리

---

# 코딩테스트 꿀팁 💡

## Comparator는 가장 중요한 스킬

PQ 문제 = Comparator 문제

---

## 다익스트라 나오면 무조건 PQ

대표 공식

```
최단거리 → PriorityQueue
```

---

## 객체 저장 패턴 익숙해지기

예시

```
Node + cost
index + value
position + distance
```

---

## poll() vs peek() 차이

| 메서드 | 설명 |
|--------|------|
| poll | 제거 |
| peek | 조회 |

---

# 자주 등장하는 문제 유형

대표 패턴

```
가장 작은 값 찾기
가장 큰 값 찾기
K번째 값 찾기
최단 거리
작업 스케줄링
```

---

# 추천 연습 문제 🧪

## 프로그래머스

- 더 맵게
- 디스크 컨트롤러
- 야근 지수

---

## 백준

- 11279 최대 힙
- 1927 최소 힙
- 1655 가운데를 말해요

---

# 이번 주 목표 ✅

✔ PriorityQueue 사용 가능  
✔ 최소 힙 / 최대 힙 구현 가능  
✔ Comparator 구현 가능  
✔ 다익스트라 준비 완료