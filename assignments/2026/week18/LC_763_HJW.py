# LC 763 - Partition Labels
# 유형: 백트래킹
# 링크: https://leetcode.com/problems/partition-labels/

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        answer = []
        front, rear = dict(), dict()
        for digit in s:
            rear[digit] = rear.get(digit, 0) + 1
        
        for i in range(len(s)):
            digit = s[i]
            front[digit] = front.get(digit, 0) + 1
            rear[digit] -= 1

            flag = True
            for d in front:
                if rear.get(d):
                    flag = False
                    break
            
            if flag:
                tmp = 0
                for v in front.values():
                    tmp += v
                answer.append(tmp)
                front = dict()
    
        return answer