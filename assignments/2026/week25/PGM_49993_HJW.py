# PGM 49993 - 스킬트리
# 유형: 그래프
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/49993

learned = {}
skill_tree = {}

def init(flag):
    
    for i in range(26):
        learned[chr(ord('A')+i)] = 0
        if flag:
            skill_tree[chr(ord('A')+i)] = 0
            
def set_skill_tree(skill):
    
    for i in range(1, len(skill)):
        skill_tree[skill[i]] = skill[i-1]

def check(tree):
    
    for sk in tree:
        if skill_tree[sk]:
            if learned[skill_tree[sk]]:
                learned[sk] = 1
            else:
                return False
                
        else:
            learned[sk] = 1
    
    return True

def solution(skill, skill_trees):
    
    answer = 0
    
    init(1)
    set_skill_tree(skill)
    
    for tree in skill_trees:
        init(0)
        if check(tree):
            answer += 1
    
    return answer