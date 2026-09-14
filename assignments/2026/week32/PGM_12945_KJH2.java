// PGM_12945 피보나치 수
// 재귀로 했다가 시간초과나서 다시 반복문으로..
// https://school.programmers.co.kr/learn/courses/30/lessons/12945

class Solution {
    public int solution(int n) {
        
        int prev = 1;
        int curr = 1;
        
        for(int i = 2; i <= n - 1; i++){
            int next = (prev + curr) % 1234567;
            prev = curr;
            curr = next;
        }
        
        return curr;
    }
   
}
