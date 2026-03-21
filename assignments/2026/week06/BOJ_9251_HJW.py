# BOJ 9251 - LCS
# 유형: DP / 문자열
# 링크: https://www.acmicpc.net/problem/9251

A = input()
B = input()
N, M = len(A), len(B)

Max = 0
lcs = [[0 for _ in range(M+1)] for _ in range(N+1)]

for i in range(N+1):
    for j in range(M+1):

        if i == 0 or j == 0:
            lcs[i][j] = 0
        
        elif A[i-1] == B[j-1]:
            lcs[i][j] = lcs[i-1][j-1] + 1
            if lcs[i][j] > Max:
                Max = lcs[i][j]
        
        else:
            lcs[i][j] = max(lcs[i-1][j], lcs[i][j-1])

print(Max)