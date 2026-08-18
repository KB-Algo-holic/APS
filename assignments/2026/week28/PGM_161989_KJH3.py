def solution(n, m, section):
    min_cnt = 1
    roller_end = section[0] + m - 1

    for s in section[1:]:
        if s > roller_end:
            min_cnt += 1
            roller_end = s + m - 1

            if roller_end > n:
                roller_end = n

    return min_cnt