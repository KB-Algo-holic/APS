// PGM 131701 - 연속 부분 수열 합의 개수
// 학습  
// https://school.programmers.co.kr/learn/courses/30/lessons/131701?language=java
import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;

        Set<Integer> set = new HashSet<Integer>();


        for(int i =1; i<=elements.length; i++)
        {
            for(int j =0; j<=elements.length; j++)
            {
                int sum =0;
                for(int k=j; k<j+i; k++)
                {
                    sum = sum + elements[k%elements.length];
                }
                set.add(sum);
            }
        }
        answer = set.size();
        return answer;
    }
}
