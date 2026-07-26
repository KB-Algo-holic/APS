# PGM 49993 - 스킬트
# 유형: 그래프 심화
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/49993

def solution(skill, skill_trees):
    answer = 0

    for skill_tree in skill_trees:
        # 현재 배워야 하는 선행 스킬의 순서
        skill_index = 0

        # 현재 스킬트리가 가능한지 확인하기 위한 변수
        possible = True

        for current_skill in skill_tree:
            # 선행 스킬 순서에 포함되지 않은 스킬은 무시한다.
            if current_skill not in skill:
                continue

            # 현재 배워야 하는 스킬과 같으면 다음 선행 스킬로 넘어간다.
            if current_skill == skill[skill_index]:
                skill_index += 1

                # 모든 선행 스킬을 배운 경우 더 이상 비교하지 않아도 된다.
                if skill_index == len(skill):
                    break

            # 현재 배워야 하는 스킬보다 뒤의 스킬을 먼저 배운 경우
            # 불가능한 스킬트리로 처리한다.
            else:
                possible = False
                break

        # 가능한 스킬트리인 경우 개수를 증가시킨다.
        if possible:
            answer += 1

    return answer
