# PGM 468370 - 중요한 단어를 스포방지
# 유형: 집합
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/468370

def solution(message, spoiler_ranges):
    words = []
    start = 0

    for i in range(len(message) + 1):
        if i == len(message) or message[i] == ' ':
            if start < i:
                words.append((message[start:i], start, i - 1))
            start = i + 1

    normal = set()
    spoiler = []

    for word, start, end in words:
        ranges = []

        for idx, (left, right) in enumerate(spoiler_ranges):
            if start <= right and end >= left:
                ranges.append(idx)

        if not ranges:
            normal.add(word)
        else:
            spoiler.append((max(ranges), start, word))

    spoiler.sort()

    seen = set()
    answer = 0

    for idx, start, word in spoiler:
        if word not in normal and word not in seen:
            answer += 1
        seen.add(word)

    return answer
