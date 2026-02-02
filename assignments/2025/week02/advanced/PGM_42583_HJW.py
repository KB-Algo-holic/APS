# PGM 42583 - 다리를 지나는 트럭
# 유형: 큐
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42583

from collections import deque

def solution(bridge_length, weight, truck_weights):
    trucks = deque(truck_weights)
    
    time = 1
    bridge = deque()
    total = 0
    
    truck = trucks.popleft()
    total += truck
    bridge.append([truck, bridge_length])
    
    while bridge or trucks:
        if bridge and bridge[0][1] == time:
            truck = bridge.popleft()
            total -= truck[0]
        
        if trucks and trucks[0] + total <= weight:
            truck = trucks.popleft()
            total += truck
            bridge.append((truck, time+bridge_length))
        
        elif bridge:
            time = bridge[0][1] - 1
        
        time += 1
            
    return time

'''
def solution(bridge_length, weight, truck_weights):
    
    answer = 0
    second = 0
    bridge = [0] * bridge_length
    total_weight = 0

    while truck_weights:
        total_weight -= bridge[0]
        del(bridge[0])
        if (total_weight + truck_weights[0]) <= weight:
            truck = truck_weights[0]
            del(truck_weights[0])
            total_weight += truck
            bridge.append(truck)
        else:
            bridge.append(0)
        second += 1
    while bridge:
        del(bridge[0])
        second += 1
    answer = second
    return answer
'''

