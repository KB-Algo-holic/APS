// PGM_12940 최대공약수와 최소공배수
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/12940

class Solution {
    public int[] solution(int n, int m) {
        
        int gcd = 0;
        int lcm = 0;
        
        if(n <= m){
            gcd = GetGCD(m, n);
        }
        else
            gcd = GetGCD(n, m);
        
        lcm = n * m / gcd;
        
        int[] answer = {gcd, lcm};
        return answer;
    }
    
    public int GetGCD(int n, int m){
        if(m == 0)
            return n;
        else{
            return GetGCD(m, n%m);
        }
    }
}
