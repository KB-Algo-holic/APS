# 📘 완전 탐색 (brute force)

## ✅ 개념 설명

완전 탐색(brute force)은 **가능한 모든 경우의 수를 탐색**하여 정답을 찾는 방식입니다.
예를 들어 4자리 암호를 풀어야 한다면, 단순히 0000부터 9999까지 모든 경우를 하나씩 시도해 보는 방식으로 암호를 알아낼 수 있습니다.
운이 좋으면 한 번에 정답을 맞힐 수도 있지만, 운이 나쁘면 최대 10,000번을 시도해야 하므로 시간이 오래 걸릴 수 있습니다.
이처럼 모든 경우의 수를 탐색하기 때문에 시간이 오래 걸리는 단점이 있지만, 정답을 100% 찾아낼 수 있다는 장점이 있는 탐색 기법입니다.

### 🔍 구조 이미지
> ![스택 구조](https://goldenrabbit.co.kr/wp-content/uploads/2024/01/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7-2024-01-03-%EC%98%A4%EC%A0%84-9.13.27.png)
> *출처: https://goldenrabbit.co.kr/2024/01/03/%EC%BD%94%EB%94%A9-%ED%85%8C%EC%8A%A4%ED%8A%B8-%ED%95%A9%EA%B2%A9%EC%9E%90-%EB%90%98%EA%B8%B0-%EB%B0%B1%ED%8A%B8%EB%9E%98%ED%82%B9-2-%EB%B0%B1%ED%8A%B8%EB%9E%98%ED%82%B9-%EC%95%8C%EA%B3%A0/*

---

## 🧮 완전 탐색의 종류

| 이름            | 설명                                      |
| ---------------- | --------------------------------------- |
| 부르트 포스 (Brute-Force) | 반복문과 조건문을 사용하여 가능한 모든 경우를 탐색하는 방식              |
| 비트마스트 (Bitmask) | 이진수의 각 비트를 사용해 상태나 선택 여부를 표현하고 계산하는 방식              |
| 백트래킹(Backtracking) | 탐색 도중에 막히면 이전 지점으로 다시 돌아가서 다른 경로를 탐색하는 방식 |
| 순열 (Permutation) | 주어진 원소들의 순서를 고려한 모든 경우를 탐색하는 방식              |
| 재귀 (Recursion)      | 자기 자신을 호출하며 모든 가능한 경우를 탐색하는 방식               |
| 너비 우선 탐색(BFS)      | 하나의 요소를 방문하고 그 요소에 인접한 모든 요소를 우선 방문하는 방식               |
| 깊이 우선 탐색(DFS)      | 한 방향으로 깊게 탐색한 뒤, 막히면 되돌아오면서 탐색하는 방식               |

---

## ⚙️ 시간 복잡도

| 이름                       | 설명                                             | 시간 복잡도 (일반적인 경우)                |
| ------------------------ | ---------------------------------------------- | ------------------------------- |
| 부르트 포스 (Brute-Force) | 반복문과 조건문을 활용해 가능한 모든 경우를 직접 탐색하는 방식            | 보통 O(Nⁿ)             |
| 비트마스크 (Bitmask)      | 이진수의 각 비트를 이용해 상태나 선택 여부를 표현하고 계산하는 방식         | O(2ⁿ × n)                       |
| 백트래킹 (Backtracking)  | 유망하지 않은 경로를 빠르게 포기하며 탐색하는 방식                   | 최악의 경우 O(n!) |
| 순열 (Permutation)     | 주어진 원소들을 다양한 순서로 나열하며 모든 경우를 탐색하는 방식           | O(n!)                           |
| 재귀 (Recursion)       | 자기 자신을 반복 호출하며 가능한 모든 경우를 탐색하는 방식              | O(2ⁿ), O(n!) 등         |
| 너비 우선 탐색 (BFS)       | 가까운 노드부터 차례로 방문하며 탐색을 수행하는 방식                  | O(V + E)                        |
| 깊이 우선 탐색 (DFS)       | 한 경로를 끝까지 따라간 뒤, 더 이상 진행할 수 없을 때 되돌아오며 탐색하는 방식 | O(V + E)                        |


---

## 🧠 사용 예시
- 비밀번호 조합
- 부분집합 생성
- N개의 수 중에서 M개 선택 (조합/순열)
- N-Queen 문제
- 경로 탐색
- 소수 찾기

---

## 🧪 예제 코드 (Java)
- 1~3까지의 숫자 중 모든 순열을 생성하는 예제입니다.
예: [1, 2, 3] → [1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]

```java
import java.util.*;

public class PermutationExample {
    static int[] nums = {1, 2, 3};        // 대상 숫자 배열
    static boolean[] visited = new boolean[3]; // 방문 여부 체크
    static List<Integer> result = new ArrayList<>(); // 현재 순열 저장

    public static void main(String[] args) {
        permute(0); // 깊이 0부터 시작
    }

    public static void permute(int depth) {
        if (depth == nums.length) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result.add(nums[i]);

                permute(depth + 1); // 다음 깊이로 재귀 호출

                // 현재 선택 취소
                visited[i] = false;
                result.remove(result.size() - 1);
            }
        }
    }
}

```

## 🧩 샘플 문제 (프로그래머스)
| 문제 이름        | 링크                                                                         |
|------------------|------------------------------------------------------------------------------|
| 게임 맵 최단거리(BFS/DFS)   | [🔗 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/1844) |
| N-Queen         | [🔗 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/12952) |
| 소수찾기         | [🔗 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/42839) |