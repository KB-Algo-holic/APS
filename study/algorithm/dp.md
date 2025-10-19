# 📘 DP (Dynamic Programming)

## ✅ 개념 설명

DP(동적 프로그래밍)는 큰 문제를 **작은 부분 문제로 나누어** 해결하고,  
그 **결과를 저장(memoization)** 하여 **중복 계산을 방지**하는 알고리즘 기법입니다.  
**재귀(Top-Down)** 또는 **반복문(Bottom-Up)** 형태로 구현할 수 있습니다.

*[Top-Down과 Bottom-Up 장단점](https://developerbbojak.tistory.com/96)*  

### 🔍 구조 이미지
> ![DP 구조 - Bottom Up](https://miro.medium.com/v2/resize:fit:720/format:webp/0*ZFdyY3sOVf6p-_Yo)  

> ![DP 구조 - Top Down](https://miro.medium.com/v2/resize:fit:720/format:webp/0*RPsaoB4_vEomU8ev)  
> *출처: [Medium](https://medium.com/@aryan.jain19/memoization-vs-tabulation-in-dp-4ff137da8044)*
---

## 🧮 주요 특징

| 항목         | 설명                                          |
|--------------|-----------------------------------------------|
| 핵심 개념     | 부분 문제의 중복을 제거하여 효율성 향상           |
| 구현 방식     | 재귀(Top-Down) / 반복문(Bottom-Up)             |
| 저장 방식     | 메모이제이션 (Memoization) / 테이블(Tabulation) |
| 대표 자료형   | 배열(list), 딕셔너리(dict) 등                  |
| 공통 패턴     | 점화식(Recurrence Relation)                    |

---

## ⚙️ 시간 복잡도

| 유형           | 시간 복잡도          |
|----------------|----------------------|
| Top-Down(메모이제이션) | O(N)               |
| Bottom-Up(반복문)     | O(N)               |
| 일반 재귀(비DP)       | O(2ⁿ) (중복 호출 발생 시) |

---

## 🧠 사용 예시
- 피보나치 수열 (Fibonacci)
- 최대/최소 비용 경로
- 배낭 문제 (Knapsack)
- 최장 증가 부분 수열 (LIS)
- 계단 오르기, 점프, 타일링 등

---

## 🧪 예제 코드 (Python)

```python
# ✅ Bottom-Up 방식
def fibonacci(n):
    dp = [0] * (n + 1)
    dp[1] = 1
    for i in range(2, n + 1):
        dp[i] = dp[i - 1] + dp[i - 2]
    return dp[n]

print(fibonacci(10))  # 출력: 55
→ 작은 문제부터 차례로 값을 채워 나가며 큰 문제를 해결.

# ✅ Top-Down 방식 (재귀 + 메모이제이션)
memo = {0: 0, 1: 1}
def fibo(n):
    if n in memo:
        return memo[n]
    memo[n] = fibo(n - 1) + fibo(n - 2)
    return memo[n]

print(fibo(10))  # 출력: 55
→ 재귀적으로 큰 문제를 쪼개 내려가며, 이미 계산한 값은 다시 계산하지 않음.
```

```java
// ✅ Bottom-Up 방식
public class DPExample {
    public static int fibonacci(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // ✅ Top-Down 방식 (메모이제이션)
    static int[] memo = new int[100];

    public static int fibo(int n) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        return memo[n] = fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("Bottom-Up: " + fibonacci(10));  // 55
        System.out.println("Top-Down: " + fibo(10));        // 55
    }
}


```
---
## 📈 점화식 도식화
| 문제 유형   | 점화식 (Recurrence Relation)                                     | 설명               |
| ------- | ------------------------------------------------------------- | ---------------- |
| 피보나치 수열 | `dp[n] = dp[n-1] + dp[n-2]`                                   | 바로 앞의 두 항의 합     |
| 계단 오르기  | `dp[n] = dp[n-1] + dp[n-2]`                                   | 한 번에 1칸 또는 2칸 이동 |
| 타일링 문제  | `dp[n] = dp[n-1] + dp[n-2]`                                   | 2×n 크기의 바닥 채우기   |
| 최대 부분합  | `dp[i] = max(arr[i], arr[i] + dp[i-1])`                       | 이전 합과 비교         |
| 배낭 문제   | `dp[i][w] = max(dp[i-1][w], dp[i-1][w-weight[i]] + value[i])` | 물건을 넣거나 안 넣는 선택  |

---
## 📊 시각화 예시
```scss
f(5)
├─ f(4)
│  ├─ f(3)
│  │  ├─ f(2)
│  │  │  ├─ f(1)
│  │  │  └─ f(0)
│  │  └─ f(1)
│  └─ f(2)
│     ├─ f(1)
│     └─ f(0)
└─ f(3)
   ├─ f(2)
   └─ f(1)

```
---
## 🗂️ 코딩 테스트용 핵심 패턴
| 패턴명             | 설명                             | 대표 문제                                                                           |
| --------------- | ------------------------------ | ------------------------------------------------------------------------------- |
| ① 피보나치 / 타일링    | 1차원 DP의 기본 구조. 점화식 기반 반복문 구현.  | [멀리 뛰기](https://school.programmers.co.kr/learn/courses/30/lessons/12914)        |
| ② 경로 탐색 (2D DP) | 2차원 배열에서 이동 경로 누적 (우, 하 방향 등). | [등굣길](https://school.programmers.co.kr/learn/courses/30/lessons/42898)          |
| ③ 최댓값 누적        | 이전 상태의 최댓값을 누적하며 갱신.           | [정수 삼각형](https://school.programmers.co.kr/learn/courses/30/lessons/43105)       |
| ④ 부분 수열 / 부분합   | 이전 원소들의 최적 상태를 기반으로 현재 상태 결정.  | [연속 부분 수열의 합](https://school.programmers.co.kr/learn/courses/30/lessons/178870) |
| ⑤ 조합형 / 배낭 문제   | 선택(포함/비포함) 분기로 최적해 도출.         | [N으로 표현](https://school.programmers.co.kr/learn/courses/30/lessons/42895)       |
---

## 🧩 샘플 문제
| 문제 이름       | 링크                                                                         |
| ----------- | -------------------------------------------------------------------------- |
| N으로 표현      | [🔗 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/42895) |
| 정수 삼각형      | [🔗 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/43105) |
| 등굣길         | [🔗 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/42898) |
| 멀리 뛰기       | [🔗 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/12914) |
| 스티커 모으기 (2) | [🔗 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/12971) |

 
