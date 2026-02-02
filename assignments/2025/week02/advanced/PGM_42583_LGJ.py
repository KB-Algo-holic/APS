# PGM 42583 - 다리를 지나는 트럭
# 유형: 큐   
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42583

def solution(bridge_length, weight, truck_weights):
    stack = []
    time = 1
    first_truck = truck_weights.pop(0)
    stack.append([first_truck, 1])

    while stack:
        # print(time, stack)
        time += 1
        total = 0

        if stack[0][1] == bridge_length:
            stack.pop(0)

        for truck in stack:
            total += truck[0]
            truck[1] += 1

        if truck_weights:
            if total + truck_weights[0] <= weight:
                new_truck = truck_weights.pop(0)
                stack.append([new_truck, 1])

    return time