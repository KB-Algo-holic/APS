# 📘 우선순위 큐 (Priority Queue)

## ✅ 개념 설명

우선순위 큐는 각 요소에 우선순위를 부여하여, **우선순위가 높은 데이터가 먼저 나오는 큐**입니다.  
일반 큐는 FIFO지만, 우선순위 큐는 **우선순위 기준으로 dequeue**됩니다.

### 🔍 구조 이미지
> ![우선순위 큐 구조](https://upload.wikimedia.org/wikipedia/commons/6/69/Min-heap.png)
> *출처: 위키백과 (힙 기반 PQ)*

---

## 🧮 주요 연산

| 연산 이름  | 설명                               |
|------------|------------------------------------|
| insert     | 우선순위와 함께 데이터 삽입         |
| delete     | 우선순위가 가장 높은 데이터 제거     |
| peek       | 최우선순위 데이터 확인              |
| isEmpty    | 큐가 비어 있는지 확인               |

---

## ⚙️ 시간 복잡도

| 연산         | 시간 복잡도 (힙 기반) |
|--------------|-----------------------|
| 삽입         | O(log n)              |
| 삭제         | O(log n)              |
| 조회         | O(1)                  |

---

## 🧠 사용 예시
- 작업 스케줄링
- 최단 경로 알고리즘 (예: 다익스트라)
- 운영체제의 프로세스 우선순위 처리

---

## 🧪 예제 코드 (Python)

```python
import heapq

pq = []
heapq.heappush(pq, (1, "Low"))
heapq.heappush(pq, (0, "High"))
heapq.heappush(pq, (2, "Lowest"))

print(heapq.heappop(pq))  # 출력: (0, 'High') — 가장 높은 우선순위부터 꺼냄
```

## 🧩 샘플 문제 (프로그래머스)
| 문제 이름      | 링크                                                                         |
|----------------|------------------------------------------------------------------------------|
| 이중우선순위큐   | [🔗 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/42628) |
| 디스크 컨트롤러 | [🔗 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/42627) |