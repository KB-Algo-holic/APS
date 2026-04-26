# PGM 92334 - 신고 결과 받기
# 유형: 카운팅
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/92334


def solution(id_list, report, k):
    answer = [0] * len(id_list)
    report_count = [0] * len(id_list)

    report = list(set(report))

    for r in report:
        user1, user2 = r.split()
        report_count[id_list.index(user2)] += 1

    for r in report:
        user1, user2 = r.split()
        if report_count[id_list.index(user2)] >= k:
            answer[id_list.index(user1)] += 1

    return answer
