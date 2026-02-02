// PGM 67257 - 수식최대화
// 유형: 큐
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/67257

import java.util.*;

class Solution {
    public long solution(String expression) {

        // 원본 저장용 deque
        Deque<String> dq = new LinkedList<>();
        // 임시 저장 deque
        Deque<String> dqTemp = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        // 수식을 숫자 , 연산자로 분리해서 dq에 저장
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*'){
                dq.offer(sb.toString());              // 숫자 추가
                dq.offer(expression.charAt(i)+"");    // 연산자 추가
                sb = new StringBuilder();
            }else{
                sb.append(expression.charAt(i));
            }
        }
        dq.offer(sb.toString()); // 마지막 숫자 추가
        dq.offer("end");         // 반복종료 위해 추가

        long answer = 0;

        // 6가지 연산자 우선순위 경우의 수 적용
        dqTemp = deque(dq);
        answer = Math.max(answer, Math.abs(Long.parseLong(multi(minus(plus(dqTemp))).poll().toString())));

        dqTemp = deque(dq);
        answer = Math.max(answer, Math.abs(Long.parseLong(minus(multi(plus(dqTemp))).poll().toString())));

        dqTemp = deque(dq);
        answer = Math.max(answer, Math.abs(Long.parseLong(multi(plus(minus(dqTemp))).poll().toString())));

        dqTemp = deque(dq);
        answer = Math.max(answer, Math.abs(Long.parseLong(plus(multi(minus(dqTemp))).poll().toString())));

        dqTemp = deque(dq);
        answer = Math.max(answer, Math.abs(Long.parseLong(plus(minus(multi(dqTemp))).poll().toString())));

        dqTemp = deque(dq);
        answer = Math.max(answer, Math.abs(Long.parseLong(minus(plus(multi(dqTemp))).poll().toString())));

        return answer;
    }

    // 원본 큐 복사
    public static Deque deque(Deque dq){
        Deque<String> dqTemp = new LinkedList<>();
        for(int i = 0; i < dq.size(); i++){
            String s = dq.poll()+"";
            dq.offer(s);
            dqTemp.offer(s);
        }
        return dqTemp;
    }

    // +
    public static Deque plus(Deque dq){
        String s = "";
        while(!s.equals("end")){
            s = dq.poll().toString();
            if(s.equals("+")){
                // 바로 앞 숫자와 다음 숫자 더함
                long l = Long.parseLong(dq.pollLast().toString()) + Long.parseLong(dq.poll().toString());
                dq.offer(l+"");
            }else{
                dq.offer(s);
            }
        }
        return dq;
    }

    // -
    public static Deque minus(Deque dq){
        String s = "";
        while(!s.equals("end")){
            s = dq.poll().toString();
            if(s.equals("-")){
                long l = Long.parseLong(dq.pollLast().toString()) - Long.parseLong(dq.poll().toString());
                dq.offer(l+"");
            }else{
                dq.offer(s);
            }
        }
        return dq;
    }

    // *
    public static Deque multi(Deque dq){
        String s = "";
        while(!s.equals("end")){
            s = dq.poll().toString();
            if(s.equals("*")){
                long l = Long.parseLong(dq.pollLast().toString()) * Long.parseLong(dq.poll().toString());
                dq.offer(l+"");
            }else{
                dq.offer(s);
            }
        }
        return dq;
    }
}
