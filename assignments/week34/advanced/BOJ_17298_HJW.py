# BOJ 17298 - 오큰수
# 유형: 스택
# 링크: https://www.acmicpc.net/problem/17298

N = int(input())
nums = list(map(int, input().split()))
res = [-1] * N
stack = []

for i in range(N):
    num = nums[i]
    while stack and num > stack[-1][0]:
        idx = stack.pop()[1]
        res[idx] = num
    
    stack.append((num, i))

print(*res)