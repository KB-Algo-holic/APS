def solution(nums):
    answer = 0

    l = len(nums)

    for i in range(l - 2):
        for j in range(i + 1, l - 1):
            for k in range(j + 1, l):
                isprime = 1
                n = nums[i] + nums[j] + nums[k]
                for a in range(2, int(n ** 0.5) + 1):
                    if n % a == 0:
                        isprime = 0
                        break
                if isprime == 1:
                    answer += 1

    return answer