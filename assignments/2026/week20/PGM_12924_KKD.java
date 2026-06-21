// PGM 12924 - 숫자의 표현
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/12924?language=java
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=1;i<=n;i++)
        {
            int sum=0;
            for(int j=i;j<=n;j++)
            {
                sum += j;
                if(sum == n)
                {
                    answer++;
                    break;
                }
                if(sum>n)
                    break;
            }
            if(answer>n)
                break;
        }
        return answer;
    }
}
