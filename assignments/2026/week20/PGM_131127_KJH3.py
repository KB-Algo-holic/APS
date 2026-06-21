from collections import Counter


def solution(want, number, discount):
    answer = 0
    dict_want = dict(zip(want, number))

    for i in range(len(discount) - 10 + 1):
        join = []
        for j in range(i, i + 10):
            join.append(discount[j])

        d = dict(Counter(join))
        if d == dict_want:
            answer += 1

    return answer