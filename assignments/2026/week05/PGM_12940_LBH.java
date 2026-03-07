// 최대공약수와 최소공배수
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/12940

class Solution {
    
    int getGCD(int n, int m) {
        int gcd = 0;
        for(int i = 1; i <= (n > m ? m : n); i++) {
            if(n % i == 0 && m % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
    
    int getLCM(int n, int m) {
        int lcm = 0;
        for(int i = (n > m ? n : m); ; i+= n > m ? n : m) {
            if(i % n == 0 && i % m == 0) {
                lcm = i;
                break;
            }
        }
        return lcm;
    }
    
    public int[] solution(int n, int m) {
        return new int[]{getGCD(n, m), getLCM(n, m)};
    }
}
