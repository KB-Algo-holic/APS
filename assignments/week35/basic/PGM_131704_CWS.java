// PGM 131704 - 택배상자
// 유형: 스택
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/131704

import java.util.*;

class Solution {
    public int solution(int[] order) {

        Deque<Integer> dq = new ArrayDeque<>();
        int answer = 0;

        for(int i = 1; i <= order.length; i++){
            // 임시 보관
            if(order[answer] != i){
                dq.offerFirst(i);
            // 바로 사용
            }else{
                answer++;
                //  다음에 필요한 경우 계속 꺼내서 적재
                while(dq.size() != 0 && order[answer] == dq.peekFirst()){
                    dq.pollFirst();
                    answer++;
                }
            }
        }
        return answer;
    }
}
