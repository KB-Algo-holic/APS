# PGM 92334 - 신고 결과 받기
# 유형: 해쉬
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/92334

def solution(id_list, report, k):
    answer = []
    
    report_dic = {}
    for rep in report:
        a, b = map(str, rep.split())
        report_dic[b] = report_dic.get(b, set())
        report_dic[b].add(a)
    
    report_cnt = {}
    for rep in report_dic:
        report_cnt[rep] = len(report_dic[rep])
    
    idx_dic = {}
    for i in range(len(id_list)):
        idx_dic[id_list[i]] = i
    
    answer = [0] * len(id_list)
    
    for target in report_cnt:
        if report_cnt[target] >= k:
            for man in report_dic[target]:
                answer[idx_dic[man]] += 1
    
    return answer