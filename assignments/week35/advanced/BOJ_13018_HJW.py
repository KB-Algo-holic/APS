# BOJ 13018 - 특이한 수열
# 유형: 정수론
# 링크: https://www.acmicpc.net/problem/13018

N, K = map(int, input().split())
X = N-K
answer = [i for i in range(1, N+1)]

if not X:
    print("Impossible")

else:
    if X%2:
        for i in range(K+1, N, 2):
            answer[i], answer[i+1] = answer[i+1], answer[i]

    elif not X%2:
        i = 0
        for _ in range(X//2):
            answer[i], answer[i+1] = answer[i+1], answer[i]
            i += 2
            
    print(*answer)