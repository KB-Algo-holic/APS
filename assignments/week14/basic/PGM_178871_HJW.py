# PGM 178871 - 달리기 경주
# 유형: 해쉬
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/178871

def solution(players, callings):
    ranking_by_name = {}
    ranking_by_rank = {}
    rank = 1
    for player in players:
        ranking_by_name[player] = rank
        ranking_by_rank[rank] = player
        rank += 1
    
    for call in callings:
        rank = ranking_by_name[call]
        target = ranking_by_rank[rank-1]
        ranking_by_name[target] += 1
        ranking_by_name[call] -= 1
        ranking_by_rank[rank] = target
        ranking_by_rank[rank-1] = call
    
    answer = []
    for rank in ranking_by_rank:
        answer.append(ranking_by_rank[rank])
    
    return answer