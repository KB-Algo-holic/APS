// PGM 43162 - 네트워크
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/43162?language=java

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!check[i]){
                dfs(computers, i, check);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int[][] computers, int i, boolean[] check){
        check[i] = true;
        
        for(int j=0;j<computers.length;j++){
            if(i != j && computers[i][j] == 1 && !check[j]){
                dfs(computers, j, check);
            }
        }
    }
}
