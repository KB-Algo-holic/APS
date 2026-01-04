# BOJ 9935 - 문자열 폭발
# 유형: 스택
# 링크: https://www.acmicpc.net/problem/9935

import sys
from collections import deque
input = sys.stdin.readline

string = list(input().rstrip())
target = input().rstrip()

size = len(target)

first = deque()
second = deque(string)

while second:
    first.append(second.popleft())
    if len(first) >= size:
        if first[-1] == target[-1]:
            res = ''
            for _ in range(size):
                res += first.pop()
            res = res[::-1]
            if res != target:
                for digit in res:
                    first.append(digit)

if first:
    while first:
        sys.stdout.write(first.popleft())
else:
    sys.stdout.write("FRULA")
sys.stdout.write('\n')