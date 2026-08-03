# PGM 64064 - 불량 사용자
# 유형: 조합
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/64064

from itertools import combinations, permutations

def compare(a, b):

    if len(a) != len(b):
        return False

    for i in range(len(a)):
        if b[i] == "*":
            continue

        if a[i] != b[i]:
            return False

    return True

def check(user, target_banned):

    flag = 0

    for ban in target_banned:
        for i in range(len(ban)):
            if compare(user[i], ban[i]):
                flag = 1
            else:
                flag = 0
                break

        if flag:
            return 1

    return 0

def solution(user_id, banned_id):

    answer = 0

    target_users = list(combinations(user_id, len(banned_id)))
    target_banned = list(set(permutations(banned_id)))

    for target in target_users:
        answer += check(target, target_banned)

    return answer