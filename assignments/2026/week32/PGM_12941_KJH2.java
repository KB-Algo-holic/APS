// PGM 12941 최솟값 만들기
// 재배열부등식 이라는걸 알게됨..
// https://school.programmers.co.kr/learn/courses/30/lessons/12941

import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0 ;i < A.length; i++){
            answer += A[i] * B[B.length - 1 - i];
        }
        return answer;
    }
}
