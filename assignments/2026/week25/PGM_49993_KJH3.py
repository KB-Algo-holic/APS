def solution(skill, skill_trees):
    answer = 0
    for skill_tree in skill_trees:
        a=list(skill)
        for st in skill_tree:
            if st in skill:
                if a.pop(0)!=st:
                    break
        else:   answer+=1

    return answer