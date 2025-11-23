# PGM 12936 - 줄 서는 방법
# 유형: 구현
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12936

fac = [1] * 21
for i in range(2, 21):
    fac[i] = fac[i-1] * i
    
def solution(n, k):
    answer = []
    nums = [i for i in range(1, n+1)]
    while nums:
        if len(nums) == 1:
            answer.append(nums.pop())
            break
            
        a = fac[len(nums)-1]
        b = fac[len(nums)]
        
        for i in range(len(nums), -1, -1):
            if i*a <= k <= b:
                if i*a == k:
                    answer.append(nums[i-1])
                    del(nums[i-1])
                else:
                    answer.append(nums[i])
                    del(nums[i])
                k -= i*a
                break
        
    return answer