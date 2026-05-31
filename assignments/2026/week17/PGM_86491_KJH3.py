def solution(sizes):
    new = []

    for i, j in sizes:
        if i < j:
            i, j = j, i
        new.append([i, j])

    garo = max(a[0] for a in new)
    sero = max(b[1] for b in new)

    return garo * sero