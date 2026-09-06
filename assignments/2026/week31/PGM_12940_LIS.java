// PGM 12940 - 최대공약수와 최소공배수
// 학습
// https://school.programmers.co.kr/learn/courses/30/lessons/12940?language=java

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = getGreatestCommonFactor(n,m);
        answer[1] = getLeastCommonMultiple(n,m,answer[0]);
        return answer;
    }
    
    //둘중의 한 쪽의 수를 나머지로 계속 나눈다..
    public int getGreatestCommonFactor(int n, int m){
        if(m == 0) return n;
        return getGreatestCommonFactor(m,n%m);
    }
    
    public int getLeastCommonMultiple(int n, int m, int gcf){
        return n*m/gcf;
    }
}
