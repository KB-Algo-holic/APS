# PGM 250137 - 붕대 감기
# 유형: 시뮬레이션
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/250137

def solution(bandage, health, attacks):
    answer = 0
    time = 0
    attack_time = [0] * 1001
    last = 0
    for attack in attacks:
        attack_time[attack[0]] = attack[1]
        if attack[0] > last:
            last = attack[0]
    
    hp = health    
    continous = 0
    while True:
        time += 1
        
        if time > last:
            answer = hp
            break
        
        if attack_time[time]:
            continous = 0
            hp = max(hp - attack_time[time], 0)
        
        if not hp:
            answer = -1
            break
        
        if not attack_time[time]:
            hp += bandage[1]
            continous += 1
            if continous == bandage[0]:
                hp += bandage[2]
                continous = 0
            
            hp = min(hp, health)
        
    return answer