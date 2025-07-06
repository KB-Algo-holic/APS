# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 43162 - 네트워크
# 유형: DFS
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43162

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] parents = init(n);
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(computers[i][j] == 1) {
                    union(parents, i, j);
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(parents[i] == i)
                answer++;
        }
        
        return answer;
    }
    
    private int[] init(int n) {
        int[] parents = new int[n];
        
        for(int i = 0; i < n; i++)
            parents[i] = i;
        
        return parents;
    }
    
    private int find(int[] parents, int a) {
        return parents[a] == a ? a : find(parents, parents[a]);
    }
    
    private void union(int[] parents, int a, int b) {
        int pa = find(parents, a);
        int pb = find(parents, b);
        
        if(pa != pb) {
            if(pa < pb) {
                parents[pb] = pa;
            } else {
                parents[pa] = pb;
            }
        }
    }
}