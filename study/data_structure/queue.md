# 📘 큐 (Queue)

## ✅ 개념 설명

큐(Queue)는 **선입선출(FIFO: First-In-First-Out)** 원칙을 따르는 선형 자료구조입니다.  
먼저 들어간 데이터가 먼저 나오는 구조입니다.

예시:

```
줄 서기

[A] [B] [C]

나가는 순서 → A → B → C
```

즉,

```
enqueue(A)
enqueue(B)
enqueue(C)
dequeue() → A
```

처럼 동작합니다.

---

## 🔍 큐의 핵심 구조 (Front / Rear 개념)

![큐 구조](https://upload.wikimedia.org/wikipedia/commons/5/52/Data_Queue.svg)

큐에는 항상 두 개의 포인터 개념이 존재합니다.

```
Front       Rear
 ↓           ↓
[A]   [B]   [C]
```

| 위치 | 설명 |
|------|------|
| front | 가장 먼저 들어온 데이터 |
| rear | 가장 마지막에 들어온 데이터 |

즉,

👉 enqueue = rear 위치에 삽입  
👉 dequeue = front 위치에서 제거

---

## 🧮 주요 연산

| 연산 이름  | 설명                          |
|------------|-------------------------------|
| enqueue    | 데이터를 큐의 뒤쪽(Rear)에 삽입 |
| dequeue    | 큐의 앞쪽(Front)에서 제거       |
| peek/front | 맨 앞의 데이터 확인            |
| isEmpty    | 큐가 비어 있는지 확인           |

---

## 1️⃣ enqueue 동작 과정

예:

```
초기 상태

Front Rear
 ↓     ↓
[A]   [B]
```

enqueue(C)

```
Front       Rear
 ↓           ↓
[A]   [B]   [C]
```

즉,

```
rear = rear + 1
데이터 삽입
```

---

## 2️⃣ dequeue 동작 과정

현재 상태:

```
Front       Rear
 ↓           ↓
[A]   [B]   [C]
```

dequeue()

```
반환값 = A
```

이후 상태:

```
Front Rear
 ↓     ↓
[B]   [C]
```

즉,

```
데이터 반환
front = front + 1
```

---

## 3️⃣ peek / front

제거하지 않고 맨 앞 데이터만 확인합니다.

```
peek() → A
```

큐 상태 변화 없음

---

## 4️⃣ isEmpty

큐가 비어 있는지 확인하는 연산입니다.

```
front > rear
```

또는

```
len(queue) == 0
```

이면 비어있음

---

## ⚙️ 시간 복잡도

큐는 매우 빠른 자료구조입니다.

| 연산 | 시간 복잡도 |
|------|--------------|
| enqueue | O(1) |
| dequeue | O(1) |
| peek | O(1) |
| 탐색 | O(n) |

👉 이유: front / rear 위치만 이동하기 때문

---

## 🧠 직관적인 실제 사용 예시

큐는 현실에서도 매우 많이 사용됩니다.

### 1️⃣ 은행 대기 번호 시스템

```
A 입장
B 입장
C 입장
```

처리 순서:

```
dequeue → A
dequeue → B
dequeue → C
```

---

### 2️⃣ 프린터 작업 처리

```
문서 A 출력 요청
문서 B 출력 요청
문서 C 출력 요청
```

출력 순서:

```
A → B → C
```

---

### 3️⃣ 운영체제 작업 스케줄링

CPU 작업 처리 예시:

```
process A
process B
process C
```

처리 순서:

```
A → B → C
```

---

### 4️⃣ 메시지 큐 (비동기 처리 시스템)

예:

```
사용자 요청 1
사용자 요청 2
사용자 요청 3
```

서버 처리 순서:

```
요청 1 → 요청 2 → 요청 3
```

Kafka / RabbitMQ 같은 시스템도 큐 기반입니다.

---

## 🚀 BFS와 큐의 관계 (매우 중요 ⭐)

코딩테스트에서 큐가 중요한 이유는 바로 **BFS의 핵심 자료구조이기 때문**입니다.

BFS는 이렇게 동작합니다:

```
가까운 노드부터 먼저 탐색
그 다음 거리 탐색
그 다음 거리 탐색
```

이 구조 자체가 큐와 동일합니다.

예:

```
A
├── B
├── C
│
├── D
├── E
```

탐색 순서:

```
A
B C
D E
```

즉,

```
enqueue(A)
dequeue(A)

enqueue(B)
enqueue(C)

dequeue(B)
enqueue(D)

dequeue(C)
enqueue(E)
```

처럼 동작합니다.

---

## 💡 BFS = 큐

그래프 탐색에서:

```
DFS = 스택
BFS = 큐
```

라고 생각하면 됩니다.

이건 코딩테스트 핵심 공식입니다.

---

## 🧪 예제 코드 (Python)

```python
from collections import deque

queue = deque()

# enqueue
queue.append("A")
queue.append("B")
queue.append("C")

print(queue)
# deque(['A', 'B', 'C'])

# dequeue
print(queue.popleft())
# A

# peek
print(queue[0])
# B

# isEmpty
print(len(queue) == 0)
# False
```

---

## 🧪 BFS를 큐로 구현하기

대표적인 BFS 구현 예시입니다.

```
A
├── B
├── C
│
├── D
└── E
```

```python
from collections import deque

graph = {
    'A': ['B', 'C'],
    'B': ['D'],
    'C': ['E'],
    'D': [],
    'E': []
}

queue = deque(['A'])
visited = []

while queue:
    node = queue.popleft()

    if node not in visited:
        visited.append(node)
        queue.extend(graph[node])

print(visited)
```

출력:

```
A B C D E
```

---

## 🎯 코딩테스트에서 큐가 등장하는 대표 패턴

다음 유형 나오면 **큐 먼저 의심하세요**

| 유형 | 예시 |
|------|------|
| BFS 탐색 | 그래프 최단 거리 |
| 거리 계산 문제 | 미로 탐색 |
| 처리 순서 문제 | 프린터 |
| 시뮬레이션 문제 | 트럭 |
| 작업 스케줄링 | 프로세스 |

특히

```
미로 탐색
최단 거리 문제
레벨 탐색 문제
순서 처리 문제
```

는 거의 항상 BFS + 큐 문제입니다.

---

## 🧩 샘플 문제 (프로그래머스)

| 문제 이름 | 링크 |
|-----------|------|
| 프린터 | https://school.programmers.co.kr/learn/courses/30/lessons/42587 |
| 프로세스 | https://school.programmers.co.kr/learn/courses/30/lessons/12920 |
| 다리를 지나는 트럭 | https://school.programmers.co.kr/learn/courses/30/lessons/42583 |
| 기능개발 | https://school.programmers.co.kr/learn/courses/30/lessons/42586 |

---

## 📌 정리 (코딩테스트 관점 핵심 포인트)

큐는 다음 상황에서 거의 반드시 등장합니다:

```
1️⃣ BFS 탐색 문제
2️⃣ 최단 거리 문제
3️⃣ 순서 처리 문제
4️⃣ 시뮬레이션 문제
5️⃣ 레벨 단위 탐색 문제
```

특히

```
BFS 이해 = 큐 이해
최단 거리 문제 = 큐 문제
```

라고 생각해도 될 정도로 매우 중요한 자료구조입니다.