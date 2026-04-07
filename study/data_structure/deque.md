# 📘 덱 (Deque)

## ✅ 개념 설명

덱(Deque, Double-Ended Queue)은  
**양쪽 끝(front / rear)에서 삽입과 삭제가 모두 가능한 선형 자료구조**입니다.

즉,

```
앞에서도 넣고
뒤에서도 넣고
앞에서도 빼고
뒤에서도 뺄 수 있음
```

이라는 특징을 가집니다.

예시:

```
Front       Rear
 ↓           ↓
[A]   [B]   [C]
```

가능한 연산:

```
append(A)
appendleft(A)
pop()
popleft()
```

---

## 🔍 덱의 핵심 구조 (Front / Rear 개념)

덱은 큐와 동일하게 **front / rear 포인터**를 사용하지만,

차이점은 다음입니다:

| 자료구조 | 삽입 가능 위치 | 삭제 가능 위치 |
|----------|----------------|----------------|
| Stack | top | top |
| Queue | rear | front |
| Deque | front + rear | front + rear |

즉,

```
stack ⊂ deque
queue ⊂ deque
```

라고 볼 수 있습니다.

---

## 🧮 주요 연산

| 연산 이름 | 설명 |
|-----------|------|
| append | 뒤쪽(rear)에 삽입 |
| appendleft | 앞쪽(front)에 삽입 |
| pop | 뒤쪽(rear) 제거 |
| popleft | 앞쪽(front) 제거 |
| peek | front 또는 rear 확인 |
| isEmpty | 비어있는지 확인 |

---

## 1️⃣ append 동작 과정 (뒤쪽 삽입)

예:

```
초기 상태

Front Rear
 ↓     ↓
[A]   [B]
```

append(C)

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

## 2️⃣ appendleft 동작 과정 (앞쪽 삽입)

현재 상태:

```
Front Rear
 ↓     ↓
[A]   [B]
```

appendleft(X)

```
Front       Rear
 ↓           ↓
[X]   [A]   [B]
```

즉,

```
front = front - 1
데이터 삽입
```

---

## 3️⃣ pop 동작 과정 (뒤쪽 제거)

현재 상태:

```
Front       Rear
 ↓           ↓
[A]   [B]   [C]
```

pop()

```
반환값 = C
```

이후 상태:

```
Front Rear
 ↓     ↓
[A]   [B]
```

---

## 4️⃣ popleft 동작 과정 (앞쪽 제거)

현재 상태:

```
Front       Rear
 ↓           ↓
[A]   [B]   [C]
```

popleft()

```
반환값 = A
```

이후 상태:

```
Front Rear
 ↓     ↓
[B]   [C]
```

---

## ⚙️ 시간 복잡도

덱은 양쪽 끝에서 빠르게 동작합니다.

| 연산 | 시간 복잡도 |
|------|--------------|
| append | O(1) |
| appendleft | O(1) |
| pop | O(1) |
| popleft | O(1) |
| 탐색 | O(n) |

👉 이유: front / rear 위치만 이동하기 때문

---

## 🧠 직관적인 실제 사용 예시

덱은 **양방향 처리가 필요한 상황**에서 사용됩니다.

### 1️⃣ 브라우저 방문 기록 (앞/뒤 이동)

```
A 방문
B 방문
C 방문
```

뒤로가기:

```
pop → C 제거
```

앞으로가기:

```
append → C 복원
```

---

### 2️⃣ 회전 문제 (Rotation)

예:

```
[A] [B] [C] [D]
```

오른쪽 회전:

```
[D] [A] [B] [C]
```

왼쪽 회전:

```
[B] [C] [D] [A]
```

덱으로 쉽게 구현 가능

---

### 3️⃣ 슬라이딩 윈도우 문제

예:

```
배열에서 길이 K 구간의 최대값 찾기
```

일반 풀이:

```
O(n²)
```

deque 사용:

```
O(n)
```

로 최적화 가능

---

## 🚀 단조 덱 (Monotonic Deque) ⭐ 매우 중요

코딩테스트에서 deque가 가장 강력해지는 순간입니다.

예:

```
배열에서 "구간 최댓값" 찾기
```

방법:

```
뒤에서 작은 값 제거
앞에서 범위 벗어난 값 제거
```

예:

```
입력:
1 3 -1 -3 5 3 6 7
```

출력:

```
3 3 5 5 6 7
```

이 문제는 deque 대표 유형입니다.

---

## 🚀 0-1 BFS와 deque 관계 (매우 중요 ⭐)

가중치가

```
0 또는 1
```

인 그래프에서 사용하는 BFS입니다.

규칙:

```
가중치 0 → appendleft()
가중치 1 → append()
```

예:

```
거리 최소값 계산 문제
```

일반 BFS보다 빠르게 해결 가능

즉,

```
0-1 BFS = deque 문제
```

입니다.

---

## 💡 deque vs stack vs queue 비교

| 자료구조 | 특징 |
|----------|------|
| Stack | LIFO |
| Queue | FIFO |
| Deque | 양쪽 삽입/삭제 가능 |

관계:

```
stack ⊂ deque
queue ⊂ deque
```

---

## 🧪 예제 코드 (Python)

```python
from collections import deque

dq = deque()

# 뒤쪽 삽입
dq.append("A")
dq.append("B")

# 앞쪽 삽입
dq.appendleft("X")

print(dq)
# deque(['X', 'A', 'B'])

# 뒤쪽 제거
print(dq.pop())
# B

# 앞쪽 제거
print(dq.popleft())
# X
```

---

## 🧪 회전 문제 예제

```python
from collections import deque

dq = deque([1, 2, 3, 4])

dq.rotate(1)

print(dq)
# deque([4, 1, 2, 3])
```

---

## 🎯 코딩테스트에서 deque가 등장하는 대표 패턴

다음 유형 나오면 **deque 먼저 의심하세요**

| 유형 | 예시 |
|------|------|
| 슬라이딩 윈도우 | 구간 최댓값 |
| 단조 구조 유지 | 히스토그램 |
| 0-1 BFS | 최단 거리 |
| 회전 문제 | 원형 배열 |
| 양방향 처리 | 시뮬레이션 |

특히

```
구간 최댓값
히스토그램
0-1 BFS
회전 큐
```

는 deque 대표 문제입니다.

---

## 🧩 샘플 문제 (프로그래머스)

| 문제 이름 | 링크 |
|-----------|------|
| 회전하는 큐 | https://www.acmicpc.net/problem/1021 |
| 슬라이딩 윈도우 최댓값 | https://www.acmicpc.net/problem/11003 |
| 히스토그램에서 가장 큰 직사각형 | https://www.acmicpc.net/problem/6549 |

---

## 📌 정리 (코딩테스트 관점 핵심 포인트)

deque는 다음 상황에서 거의 반드시 등장합니다:

```
1️⃣ 슬라이딩 윈도우 최적화
2️⃣ 단조 스택/덱 문제
3️⃣ 0-1 BFS
4️⃣ 회전 문제
5️⃣ 양방향 탐색 문제
```

특히

```
구간 최댓값 문제 = deque 문제
0-1 BFS 문제 = deque 문제
```

라고 생각해도 될 정도로 매우 중요한 자료구조입니다.