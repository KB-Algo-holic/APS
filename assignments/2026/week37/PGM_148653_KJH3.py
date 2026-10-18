from collections import deque

def solution(storey):
    answer = int(1e9)
    q = deque([[storey, 0]])

    while q:
        n, cnt = q.popleft()

        while n > 0:
            if n < 10:
                if n <= 5:
                    cnt += n
                else:
                    cnt += (10-n%10)+1
                answer = min(answer, cnt)
                break


            if n%10 < 5:
                cnt += n%10
                n = n // 10
            elif n%10 > 5:
                cnt += (10 - n%10)
                n = (n // 10)+1
            else:
                q.append([n//10, cnt + 5])
                q.append([((n // 10)+1), cnt + 5])
                break

    return answer