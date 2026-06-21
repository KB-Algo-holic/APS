# LC 125 - Valid Palindrome
# 유형: 투 포인터
# 링크: https://leetcode.com/problems/valid-palindrome/

class Solution:
    def isPalindrome(self, s: str) -> bool:
        string = ""
        for d in s:
            if d.isalnum():
                string += d.lower()
        front, end = 0, len(string)-1

        while front <= end:
            if string[front] != string[end]:
                return False
            front += 1
            end -= 1

        return True