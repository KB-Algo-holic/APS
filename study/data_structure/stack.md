# 📘 스택 (Stack)

## ✅ 개념 설명

스택(Stack)은 **후입선출(LIFO: Last-In-First-Out)** 원칙을 따르는 선형 자료구조입니다.  
가장 마지막에 삽입된 데이터가 가장 먼저 삭제되는 구조입니다.

### 🔍 구조 이미지
> ![스택 구조](https://upload.wikimedia.org/wikipedia/commons/b/b4/Lifo_stack.png)
> *출처: 위키백과*

---

## 🧮 주요 연산

| 연산 이름  | 설명                         |
|------------|------------------------------|
| push       | 데이터를 스택의 top에 삽입    |
| pop        | 스택의 top에서 제거           |
| peek/top   | 맨 위(top)의 데이터 확인      |
| isEmpty    | 스택이 비어 있는지 확인       |

---

## ⚙️ 시간 복잡도

| 연산     | 시간 복잡도 |
|----------|--------------|
| 삽입     | O(1)         |
| 삭제     | O(1)         |
| 탐색     | O(n)         |

---

## 🧠 사용 예시
- 괄호 짝 검사
- DFS(깊이 우선 탐색)
- 웹 브라우저 방문 기록
- 실행 취소(Undo)

---

## 🧪 예제 코드 (Python)

```python
stack = []

# 데이터 삽입
stack.append("A")
stack.append("B")
stack.append("C")

# 데이터 제거
print(stack.pop())  # 출력: C
print(stack[-1])    # 출력: B (peek)
print(len(stack) == 0)  # False (비어있는지 확인)
```

## 🧩 샘플 문제 (프로그래머스)
| 문제 이름        | 링크                                                                         |
|------------------|------------------------------------------------------------------------------|
| 올바른 괄호       | [🔗 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/12909) |
| 기능개발         | [🔗 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/42586) |
| 탑              | [🔗 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/42588) |