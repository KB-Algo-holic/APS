# 3월 4주차 - 배열 & 리스트 (정렬)

## 목표

배열(Array)과 리스트(List)는 코딩테스트에서 가장 많이 사용하는 기본 자료구조입니다.

이번 주차에서는

- 배열 순회
- 리스트 활용
- 정렬 알고리즘 활용
- 정렬 기준 커스터마이징

을 익히는 것이 목표입니다.

특히 정렬은 **탐색, 그리디, 이분탐색, 투포인터** 등 다양한 알고리즘의 기반이 됩니다.

---

# 배열 (Array)

## 배열이란

같은 타입의 데이터를 연속된 메모리 공간에 저장하는 자료구조입니다.

예시

```java
int[] arr = new int[5];
```

초기화

```java
int[] arr = {1, 2, 3, 4, 5};
```

---

# 배열 순회 패턴

## 기본 반복문

```java
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

---

## 향상된 for문

```java
for (int num : arr) {
    System.out.println(num);
}
```

주의

인덱스 접근이 필요하면 일반 for문 사용

---

# 리스트 (ArrayList)

## 리스트 선언

```java
ArrayList<Integer> list = new ArrayList<>();
```

값 추가

```java
list.add(10);
```

값 접근

```java
list.get(0);
```

값 삭제

```java
list.remove(0);
```

크기 확인

```java
list.size();
```

---

# 배열 vs 리스트 차이

| 항목 | 배열 | 리스트 |
|------|------|--------|
| 크기 | 고정 | 가변 |
| 속도 | 빠름 | 상대적으로 느림 |
| 편의성 | 낮음 | 높음 |
| 사용 추천 | 데이터 크기 고정 | 데이터 크기 변화 |

코딩테스트에서는 상황에 따라 선택하면 됩니다.

---

# 정렬 (Sorting)

정렬은 데이터를 특정 기준에 맞게 순서대로 배치하는 작업입니다.

대표 정렬 기준

- 오름차순
- 내림차순
- 사용자 정의 기준

---

# 배열 정렬

## 오름차순 정렬

```java
Arrays.sort(arr);
```

---

## 내림차순 정렬 (Integer 배열)

```java
Arrays.sort(arr, Collections.reverseOrder());
```

주의

기본형 int 배열에서는 사용 불가

따라서

```java
Integer[] arr
```

로 선언해야 합니다.

---

# 리스트 정렬

## 오름차순 정렬

```java
Collections.sort(list);
```

---

## 내림차순 정렬

```java
Collections.sort(list, Collections.reverseOrder());
```

---

# 사용자 정의 정렬 (Comparator)

## 2차원 배열 정렬

예시: 첫 번째 값 기준 정렬

```java
Arrays.sort(arr, (a, b) -> a[0] - b[0]);
```

---

## 두 번째 값 기준 정렬

```java
Arrays.sort(arr, (a, b) -> a[1] - b[1]);
```

---

## 여러 기준 정렬

첫 번째 기준 같으면 두 번째 기준 적용

```java
Arrays.sort(arr, (a, b) -> {
    if (a[0] == b[0]) {
        return a[1] - b[1];
    }
    return a[0] - b[0];
});
```

---

# 문자열 정렬

## 길이 기준 정렬

```java
Arrays.sort(arr, (a, b) -> a.length() - b.length());
```

---

## 사전순 정렬

```java
Arrays.sort(arr);
```

---

# 자주 사용하는 정렬 패턴

## 절댓값 기준 정렬

```java
Arrays.sort(arr, (a, b) -> Math.abs(a) - Math.abs(b));
```

---

## 문자열 길이 + 사전순 정렬

```java
Arrays.sort(arr, (a, b) -> {
    if (a.length() == b.length()) {
        return a.compareTo(b);
    }
    return a.length() - b.length();
});
```

---

# 정렬 문제 접근 방법

## Step 1 정렬 기준 찾기

문제에서 요구하는 기준 확인

예시

- 값 기준
- 길이 기준
- 좌표 기준
- 우선순위 기준

---

## Step 2 정렬 후 탐색 여부 확인

정렬 문제는 보통 이후 단계가 존재합니다

예시

- 정렬 후 최대값 찾기
- 정렬 후 최소 차이 찾기
- 정렬 후 조건 만족 탐색

---

## Step 3 Comparator 설계

정렬 기준을 코드로 표현

예시

```java
(a, b) -> a[0] - b[0]
```

---

# 코딩테스트 꿀팁

## 정렬 후 풀이 가능성 먼저 확인

많은 문제는 정렬하면 쉽게 풀립니다

예시

- 최솟값 차이 문제
- 회의실 배정
- 구간 문제

---

## int vs Integer 차이 기억하기

내림차순 정렬 시

```java
int[] ❌
Integer[] ⭕
```

---

## compareTo 활용

문자열 정렬에서 자주 사용

```java
a.compareTo(b)
```

결과 의미

| 값 | 의미 |
|----|------|
| 음수 | a < b |
| 0 | 같다 |
| 양수 | a > b |

---

## 정렬 시간복잡도

Java 기본 정렬

```
O(N log N)
```

대부분의 코딩테스트에서 충분히 빠릅니다

---

# 추천 연습 문제

## 프로그래머스

- K번째 수
- 가장 큰 수
- 문자열 내 마음대로 정렬하기

---

## 백준

- 2750 수 정렬하기
- 1181 단어 정렬
- 10814 나이순 정렬

---

# 이번 주 목표

✔ 배열 순회에 익숙해지기  
✔ ArrayList 사용법 익히기  
✔ Comparator 정렬 구현 가능  
✔ 정렬 후 문제 해결 패턴 이해