// PGM 86971 - 전력망을 둘로 나누기
// 트리
// https://school.programmers.co.kr/learn/courses/30/lessons/86971


def solution(n, wires):
    answer = 100

    for i in range(len(wires)):
        visited = [False] * (n + 1)
        stack = [1]
        count = 0

        while stack:
            now = stack.pop()

            if visited[now]:
                continue

            visited[now] = True
            count += 1

            for j in range(len(wires)):
                if i == j:
                    continue

                a = wires[j][0]
                b = wires[j][1]

                if a == now and visited[b] == False:
                    stack.append(b)

                if b == now and visited[a] == False:
                    stack.append(a)

        result = abs(count - (n - count))

        if answer > result:
            answer = result

    return answer
