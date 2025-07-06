# PGM 172927 - 광물캐기
# 유형: 그리디/시뮬
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/172927


def solution(picks, minerals):
    answer = 0
    minerals_dict = {'diamond': {0:1, 1:5, 2:25}, 'iron': {0:1, 1:1, 2:5}, 'stone': {0:1, 1:1, 2:1}}
    # 비싼 원석들이 많은 그룹 순으로 정렬
    sorted_groups = sort_minerals_by_fatigue_stone(picks, minerals)
    
    for group in sorted_groups: # 최소 피로도 > 비싼 원석 그룹은 좋은 장비 순으로 
        if picks[0]: # diamond 곡괭이
            for mineral in group:
                answer += minerals_dict[mineral][0]
            picks[0] -= 1
        elif picks[1]: # iron 곡괭이
            for mineral in group:
                answer += minerals_dict[mineral][1]
            picks[1] -= 1
        elif picks[2]: # stone 곡괭이
            for mineral in group:
                 answer += minerals_dict[mineral][2]
            picks[2] -= 1
        else: # 곡괭이 소진
            break

    return answer

def fatigue_stone(mineral_group): # 광물 그룹 별 피로도의 합
    fatigue_table = {'diamond': 25, 'iron': 5, 'stone': 1} # 각 광물의 최대 피로도
    return sum(fatigue_table[mineral] for mineral in mineral_group)

def sort_minerals_by_fatigue_stone(picks, minerals): # 5개씩 그룹화 및 피로도가 높은 순 정렬
    max_minerals = sum(picks) * 5
    minerals = minerals[:max_minerals]  
    grouped_minerals = [minerals[i:i+5] for i in range(0, len(minerals), 5)]#[dia, iron, stone], [stone, stone, stone]]
    
    sorted_groups = sorted(grouped_minerals, key=fatigue_stone, reverse=True) 
    return sorted_groups
