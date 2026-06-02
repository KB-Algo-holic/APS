# LC 51 - N-Queens
# 유형: 백트래킹
# 링크: https://leetcode.com/problems/n-queens/

class Solution:
    board = []
    answer = []

    def is_possible(self, n, x, y):

        a = x-1
        while a >= 0:
            if self.board[a][y] != '.':
                return False
            a -= 1
        
        a, b = x-1, y-1
        while a >= 0 and b >= 0:
            if self.board[a][b] != '.':
                return False
            a -= 1
            b -= 1
        
        a, b = x-1, y+1
        while a >= 0 and b < n:
            if self.board[a][b] != '.':
                return False
            a -= 1
            b += 1
        
        return True
    
    def dfs(self, n, depth):

        if depth == n:
            res = []
            for i in range(n):
                res.append(''.join(self.board[i]))
            self.answer.append(res)
            return

        for i in range(n):
            self.board[depth][i] = 'Q'
            res = self.is_possible(n, depth, i)
            if res:
                self.dfs(n, depth+1)
            self.board[depth][i] = '.'

    def solveNQueens(self, n: int) -> List[List[str]]:
        self.board = [['.' for _ in range(n)] for _ in range(n)]
        self.answer = []
        self.dfs(n, 0)

        return self.answer