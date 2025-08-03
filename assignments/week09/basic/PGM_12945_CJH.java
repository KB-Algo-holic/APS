// PGM 12945 - 피보나치 수
// 유형 : 동적계획법
// 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12945

public class Solution {
    public int solution(int n) {
        int answer = function(n);
        
        return answer%12345674;
    }
    
    private int function(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        int sum = function(n-2) + function(n-1);
        
        return sum;
    }
    
    public static void main(String[] args) {
        new Solution().solution(10);
    }
}