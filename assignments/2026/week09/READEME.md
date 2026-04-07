# 4월 1주차 - 스택 / 큐 / 덱 (선형자료구조)

## 목표

스택(Stack), 큐(Queue), 덱(Deque)은 코딩테스트에서 가장 많이 등장하는 선형 자료구조입니다.

이번 주차 목표

- 스택 활용 문제 해결
- 큐 활용 문제 해결
- 덱 활용 문제 해결
- 자료구조 선택 기준 이해

특히 다음 알고리즘의 기초가 됩니다

- DFS
- BFS
- 괄호 문제
- 슬라이딩 윈도우
- 시뮬레이션

---

# 선형 자료구조란

데이터가 **일렬로 저장되는 구조**

대표 예시

- 배열
- 리스트
- 스택
- 큐
- 덱

특징

입력 순서가 중요합니다

---

# 스택 (Stack)

## 개념

후입선출 구조 (LIFO)

Last In First Out

예시

```
push(1)
push(2)
push(3)

pop() → 3
```

---

# 스택 기본 연산

| 연산 | 설명 |
|------|------|
| push | 데이터 삽입 |
| pop | 데이터 제거 |
| peek | top 확인 |
| isEmpty | 비어있는지 확인 |

---

# Java 스택 사용법

선언

```java
Stack<Integer> stack = new Stack<>();
```

삽입

```java
stack.push(10);
```

삭제

```java
stack.pop();
```

조회

```java
stack.peek();
```

비었는지 확인

```java
stack.isEmpty();
```

---

# 스택 활용 문제 유형

## 괄호 검사 문제

대표 유형

- 올바른 괄호
- 괄호 짝 맞추기

풀이 패턴

```java
if (c == '(') {
    stack.push(c);
} else {
    stack.pop();
}
```

---

## 최근 데이터 추적 문제

예시

- 뒤로가기 기능
- 이전 상태 복원
- undo 기능

---

## 문자열 뒤집기

```java
Stack<Character> stack = new Stack<>();
```

문자 하나씩 push 후 pop

---

# 큐 (Queue)

## 개념

선입선출 구조 (FIFO)

First In First Out

예시

```
offer(1)
offer(2)
offer(3)

poll() → 1
```

---

# 큐 기본 연산

| 연산 | 설명 |
|------|------|
| offer | 데이터 삽입 |
| poll | 데이터 제거 |
| peek | 앞 데이터 확인 |

---

# Java 큐 사용법

선언

```java
Queue<Integer> queue = new LinkedList<>();
```

삽입

```java
queue.offer(10);
```

삭제

```java
queue.poll();
```

조회

```java
queue.peek();
```

---

# 큐 활용 문제 유형

## BFS (너비 우선 탐색)

대표 사용 예시

- 최단 거리 탐색
- 미로 문제
- 그래프 탐색

기본 구조

```java
Queue<Integer> queue = new LinkedList<>();

queue.offer(start);

while (!queue.isEmpty()) {
    int now = queue.poll();
}
```

---

## 작업 처리 순서 문제

예시

- 프린터 문제
- 프로세스 처리
- 대기열 처리

---

# 덱 (Deque)

## 개념

양쪽에서 삽입 / 삭제 가능한 자료구조

Double Ended Queue

예시

```
addFirst(1)
addLast(2)

removeFirst()
removeLast()
```

---

# Java 덱 사용법

선언

```java
Deque<Integer> deque = new ArrayDeque<>();
```

앞 삽입

```java
deque.addFirst(10);
```

뒤 삽입

```java
deque.addLast(20);
```

앞 삭제

```java
deque.removeFirst();
```

뒤 삭제

```java
deque.removeLast();
```

---

# 덱 활용 문제 유형

## 슬라이딩 윈도우 문제

대표 예시

- 최대값 찾기
- 최소값 찾기

예시 구조

```java
Deque<Integer> deque = new ArrayDeque<>();
```

인덱스 저장 방식 사용

---

## 양방향 탐색 문제

예시

- 회전 큐
- 카드 문제
- 배열 회전 문제

---

# 스택 vs 큐 vs 덱 비교

| 자료구조 | 특징 | 사용 예시 |
|----------|------|----------|
| 스택 | LIFO | 괄호 검사 |
| 큐 | FIFO | BFS |
| 덱 | 양방향 | 슬라이딩 윈도우 |

---

# 자료구조 선택 기준

이 상황이면 스택

- 최근 값 먼저 사용
- 되돌리기 기능
- 괄호 문제

이 상황이면 큐

- 순서대로 처리
- BFS 탐색
- 작업 처리 문제

이 상황이면 덱

- 양방향 처리 필요
- 슬라이딩 윈도우
- 회전 문제

---

# 코딩테스트 꿀팁

## Stack 대신 Deque 사용 가능

Java에서는

```java
Stack
```

보다

```java
Deque
```

사용 권장

이유

속도 더 빠름

---

## BFS는 무조건 Queue

그래프 탐색에서

```
DFS → Stack
BFS → Queue
```

기본 공식처럼 사용

---

## 덱은 슬라이딩 윈도우 필수 도구

대표 문제 유형

- 구간 최대값
- 구간 최소값

---

# 시간복잡도

| 연산 | 시간복잡도 |
|------|------------|
| 삽입 | O(1) |
| 삭제 | O(1) |
| 조회 | O(1) |

모든 연산이 매우 빠름

---

# 추천 연습 문제

## 프로그래머스

- 올바른 괄호
- 같은 숫자는 싫어
- 기능개발
- 프로세스

---

## 백준

- 10828 스택
- 10845 큐
- 18258 큐2
- 2164 카드2

---

# 이번 주 목표

✔ 스택 문제 풀이 가능  
✔ 큐 기반 BFS 이해  
✔ 덱 활용 문제 해결 가능  
✔ 자료구조 선택 기준 이해