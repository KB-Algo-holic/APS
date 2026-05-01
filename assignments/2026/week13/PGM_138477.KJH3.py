# 2022년 제출코드
# def solution(k, score):
#     answer = []
#     rank = []
#
#     for i in score:
#         if len(rank) < k:
#             rank.append(i)
#         elif rank[0] < i:
#             rank[0] = i
#
#         rank.sort()
#         answer.append(rank[0])
#
#     return answer

# heapq 사용하기
import heapq

def solution(k, score):
    answer = []
    rank = []

    for s in score:

        heapq.heappush(rank, s)

        if len(rank) > k:
            heapq.heappop(rank)

        answer.append(rank[0])

    return answer