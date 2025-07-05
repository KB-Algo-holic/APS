// PGM 12987 - 숫자게임
// 유형: 스택/큐
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12987

import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Deque<Integer> dq_A = new LinkedList<>();
        Deque<Integer> dq_B = new LinkedList<>();

        Arrays.sort(A);
        Arrays.sort(B);

        //높은 순으로 A 와 B deque 에 값 입력
        //{7,5,3,1}, {8,6,2,2}
        for(int num : A){
            dq_A.offerFirst(num);
        }
        for(int num : B){
            dq_B.offerFirst(num);
        }

        while(!dq_A.isEmpty()){
            //각각 가장 높은 수를 비교해서 B가 더 큰경우 둘 다 높은 수를 제거하고 승점 1추가
            if(dq_A.peekFirst() < dq_B.peekFirst()){
                dq_A.pollFirst();
                dq_B.pollFirst();
                answer++;
            //같거나 A가 높은경우 A의 가장 높은 수 B의 가장 늦은 수를 제거
            }else{
                dq_A.pollFirst();
                dq_B.pollLast();
            }
        }

        return answer;
    }
}