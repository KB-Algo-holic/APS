// PGM 176962 - 과제 진행하기
// 스택/큐
// https://school.programmers.co.kr/learn/courses/30/lessons/176962

import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {

        // 시간(HH:mm)을 분 단위로 변환
        for(int i = 0; i < plans.length; i++){
            String[] s = plans[i][1].split(":");
            int n = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
            plans[i][1] = n+"";
        }

        // 시작 시간 기준 오름차순 정렬
        Arrays.sort(plans,(a,b)-> a[1].equals(b[1]) ?
                Integer.compare(Integer.parseInt(b[1]), Integer.parseInt(a[1])):
                Integer.compare(Integer.parseInt(a[1]), Integer.parseInt(b[1]))
        );

        Deque<String> stringDq = new LinkedList<>();
        Deque<Integer> intDq = new LinkedList<>();

        String[] answer = new String[plans.length];
        int answerCnt = 0;

        for(int i = 0; i < plans.length-1; i++){
            int n1 = Integer.parseInt(plans[i][1]);
            int n2 = Integer.parseInt(plans[i][2]);
            int n3 = Integer.parseInt(plans[i+1][1]);

            // 현재 과제를 끝낼 수 있는 경우
            if(n1 + n2 <= n3){
                answer[answerCnt++] = plans[i][0];
                // 남는 시간 계산
                int saveTime = n3 - (n1 + n2);

                while(!intDq.isEmpty()){
                    if(intDq.peekLast() <= saveTime){
                        answer[answerCnt++] = stringDq.pollLast();
                        saveTime -= intDq.pollLast();
                    }else{ // 다 못 끝내면 남은 시간 갱신
                        saveTime = intDq.pollLast() - saveTime;
                        intDq.offerLast(saveTime);
                        break;
                    }
                }
            }else{ // 현재 과제를 중단하고 스택에 저장
                stringDq.offerLast(plans[i][0]);
                intDq.offerLast(n1+n2-n3);
            }
        }

        answer[answerCnt++] = plans[plans.length-1][0];  // 마지막 과제는 무조건 완료
        while(!stringDq.isEmpty()){
            answer[answerCnt++] = stringDq.pollLast();
        }

        return answer;
    }
}