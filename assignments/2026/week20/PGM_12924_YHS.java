// PGM - 12924 L2_숫자의표현
// 투포인터
// https://school.programmers.co.kr/learn/courses/30/lessons/12924?language=java
public class PGM_12924_YHS {
    public int solution(int n) {
        int answer = 0;
        
        int start = 1;
        int end = 1;
        
        int sum = 1;
        
        while(end < n){
            // System.out.println(sum);
            if(sum == n){
                answer++;
                sum += ++end;
            }else if(sum < n){
                sum += ++end;
            }else{
                sum -= start++;
            }
        }
        
        return answer+1;
    }
}
