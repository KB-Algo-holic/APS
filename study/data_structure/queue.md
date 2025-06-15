# 📘 큐 (Queue)

## ✅ 개념 설명

큐(Queue)는 **선입선출(FIFO: First-In-First-Out)** 원칙을 따르는 선형 자료구조입니다.  
먼저 들어간 데이터가 먼저 나오는 구조로, 한쪽에서는 데이터를 넣고(삽입), 반대쪽에서는 데이터를 꺼냅니다(삭제).

### 🔍 구조 이미지
> ![큐 구조](https://upload.wikimedia.org/wikipedia/commons/5/52/Data_Queue.svg)
> *출처: 위키백과*

---

## 🧮 주요 연산

| 연산 이름  | 설명                          |
|------------|-------------------------------|
| enqueue    | 데이터를 큐의 뒤쪽(Rear)에 삽입 |
| dequeue    | 큐의 앞쪽(Front)에서 제거       |
| peek/front | 맨 앞의 데이터 확인            |
| isEmpty    | 큐가 비어 있는지 확인           |

---

## ⚙️ 시간 복잡도

| 연산          | 시간 복잡도 |
|---------------|-------------|
| 삽입 (enqueue) | O(1)        |
| 삭제 (dequeue) | O(1)        |
| 탐색           | O(n)        |

> **큐는 일반적으로 연결 리스트나 배열(deque 등)을 사용해 구현되며**, 파이썬에서는 `collections.deque`를 사용하면 효율적입니다.

---

## 🧠 사용 예시
- 너비 우선 탐색 (BFS)
- 운영체제의 작업 스케줄러
- 인쇄 대기열 시스템
- 비동기 작업 처리 (예: 메시지 큐)

---

## 🧪 예제 코드 (Python, java, kotlin)

```python
from collections import deque

# 큐 생성
q = deque()

# 데이터 삽입
q.append("A")
q.append("B")
q.append("C")

# 데이터 제거
print(q.popleft())  # 출력: A
print(q[0])         # 출력: B (peek)
print(len(q) == 0)  # False (비어있는지 확인)
```

## 🧩 샘플 문제 (프로그래머스)
| 문제 이름      | 링크                                                                         |
| ---------- | -------------------------------------------------------------------------- |
| 프린터        | [🔗 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/42587) |
| 프로세스       | [🔗 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/12920) |
| 다리를 지나는 트럭 | [🔗 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/42583) |
| 기능개발       | [🔗 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/42586) |
