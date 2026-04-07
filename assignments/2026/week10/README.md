# 4월 2주차 - 해시 (Hash)

## 목표

해시(Hash)는 **빠른 탐색(O(1))** 을 가능하게 하는 자료구조입니다.

코딩테스트에서 해시는 다음 상황에서 매우 자주 등장합니다

- 등장 횟수 세기
- 중복 확인
- 빠른 탐색
- 값 매핑
- 조합 탐색 최적화

특히 다음 문제 유형에서 필수입니다

- 빈도수 계산
- 문자열 문제
- 완전탐색 최적화
- Two Sum 유형

---

# 해시(Hash)란

해시는 데이터를 **Key → Value 형태로 저장하는 자료구조**입니다.

예시

```
"apple" → 3
"banana" → 5
```

특징

탐색 속도

```
O(1)
```

---

# Java에서 해시 자료구조

대표적으로 사용되는 구조

| 자료구조 | 특징 |
|----------|------|
| HashMap | Key-Value 저장 |
| HashSet | 중복 제거 |
| Hashtable | 동기화 지원 (거의 사용 안함) |

코딩테스트에서는 보통

```
HashMap
HashSet
```

사용

---

# HashMap 사용법

선언

```java
HashMap<String, Integer> map = new HashMap<>();
```

삽입

```java
map.put("apple", 1);
```

조회

```java
map.get("apple");
```

삭제

```java
map.remove("apple");
```

존재 여부 확인

```java
map.containsKey("apple");
```

크기 확인

```java
map.size();
```

---

# HashSet 사용법

선언

```java
HashSet<Integer> set = new HashSet<>();
```

삽입

```java
set.add(10);
```

삭제

```java
set.remove(10);
```

존재 여부 확인

```java
set.contains(10);
```

---

# 해시 활용 문제 유형

## 1️⃣ 등장 횟수 세기

가장 대표적인 유형

예시

```
문자 등장 횟수
숫자 등장 횟수
단어 등장 횟수
```

패턴

```java
map.put(x, map.getOrDefault(x, 0) + 1);
```

---

## 2️⃣ 중복 여부 확인

예시

```
배열 내 중복 확인
문자열 중복 문자 확인
```

패턴

```java
if (set.contains(x))
```

---

## 3️⃣ 빠른 탐색

예시

```
특정 값 존재 여부 확인
```

패턴

```java
map.containsKey(x)
```

또는

```java
set.contains(x)
```

---

## 4️⃣ Two Sum 문제 유형

대표적인 해시 활용 문제

예시

```
a + b = target
```

패턴

```java
map.put(value, index);
```

탐색

```java
target - value
```

---

# 해시 순회 방법

## Key 순회

```java
for (String key : map.keySet()) {
    System.out.println(key);
}
```

---

## Value 순회

```java
for (int value : map.values()) {
    System.out.println(value);
}
```

---

## Key + Value 순회

```java
for (String key : map.keySet()) {
    System.out.println(key + " " + map.get(key));
}
```

또는

```java
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " " + entry.getValue());
}
```

---

# 자주 사용하는 해시 패턴

## 빈도수 계산

```java
map.put(x, map.getOrDefault(x, 0) + 1);
```

가장 많이 등장하는 코드

코딩테스트 필수 패턴

---

## 중복 제거

```java
HashSet<Integer> set = new HashSet<>(list);
```

---

## 존재 여부 확인

```java
if (set.contains(x))
```

---

## 최대 빈도수 찾기

```java
int max = 0;

for (int value : map.values()) {
    max = Math.max(max, value);
}
```

---

# HashMap vs HashSet 차이

| 자료구조 | 저장 형태 | 사용 목적 |
|----------|----------|----------|
| HashMap | Key-Value | 빈도수 계산 |
| HashSet | Key only | 중복 제거 |

---

# 코딩테스트 꿀팁

## 등장 횟수 문제는 무조건 HashMap

예시

```
문자가 몇 번 등장했는가?
숫자가 몇 번 등장했는가?
```

---

## 중복 제거 문제는 HashSet

예시

```
중복 제거
서로 다른 개수 구하기
```

---

## containsKey 대신 getOrDefault 사용 가능

기존 방식

```java
if (map.containsKey(x)) {
    map.put(x, map.get(x) + 1);
}
```

개선 방식

```java
map.put(x, map.getOrDefault(x, 0) + 1);
```

---

## 문자열 문제에서 해시 매우 중요

대표 유형

```
아나그램
빈도 비교
문자 등장 횟수 비교
```

---

# 시간복잡도

| 연산 | 시간복잡도 |
|------|------------|
| 삽입 | O(1) |
| 삭제 | O(1) |
| 조회 | O(1) |

충돌이 많을 경우

```
O(N)
```

하지만 거의 발생하지 않음

---

# 추천 연습 문제

## 프로그래머스

- 완주하지 못한 선수
- 폰켓몬
- 베스트앨범

---

## 백준

- 10815 숫자 카드
- 14425 문자열 집합
- 1620 나는야 포켓몬 마스터 이다솜

---

# 이번 주 목표

✔ HashMap 사용 익숙해지기  
✔ HashSet 활용 가능  
✔ 등장 횟수 계산 문제 해결 가능  
✔ Two Sum 유형 이해