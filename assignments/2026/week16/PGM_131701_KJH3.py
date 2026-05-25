def solution(elements):
    list = set()
    elen = len(elements)

    for i in range(elen):
        for j in range(elen):
            if i + j > elen:
                index = i + j - elen
                list.add(sum(elements[j:]) + sum(elements[:index]))
            else:
                list.add(sum(elements[j:j + i]))
    answer = len(list)
    return answer