// PGM 42883 - 큰 수 만들기
// Greedy
// https://school.programmers.co.kr/learn/courses/30/lessons/42883


def solution(number, k):
    answer = []

    for num in number:
        while answer and k > 0 and answer[-1] < num:
            answer.pop()
            k -= 1

        answer.append(num)

    if k > 0:
        answer = answer[:-k]

    return ''.join(answer)
