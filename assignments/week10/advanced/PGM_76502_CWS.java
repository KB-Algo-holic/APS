// PGM 76502 - 괄호 회전하기
// 유형: 스택 큐
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/76502

import java.util.*;

class Solution {
    public int solution(String s) {

        Queue<Character> q = new LinkedList<>(); // 문자열을 회전시키기 위한 큐
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[6]; // 괄호 개수 체크용 ((), {}, [])
        int answer = 0;
        int num = s.length();
        boolean b = true;       // 현재 괄호 문자열이 올바른지 여부
        boolean[] arr_b = new boolean[3]; // 현재 열린 괄호 타입 체크

        // 문자열을 큐에 넣으면서 괄호 개수 카운트
        for(int i = 0; i < s.length(); i++){
            q.offer(s.charAt(i));
            switch(s.charAt(i)){
                case '(' : arr[0]++; break;
                case ')' : arr[1]++; break;
                case '{' : arr[2]++; break;
                case '}' : arr[3]++; break;
                case '[' : arr[4]++; break;
                case ']' : arr[5]++; break;
            }
        }

        // 괄호 종류별 개수가 맞는 경우만 회전 검사
        if(arr[0] == arr[1] && arr[2] == arr[3] && arr[4] == arr[5]){
            for(int i = 0; i < num; i++){ // 회전 횟수
                int[] t = new int[3];     // 각 괄호 타입별 현재 열림 개수

                // 현재 문자열이 올바른지 검사
                for(int j = 0; j < num; j++){
                    if(s.charAt(j) == '('){
                        t[0]++; arr_b[0] = true; arr_b[1] = false; arr_b[2] = false;
                    }else if(s.charAt(j) == ')'){
                        t[0]--; arr_b[0] = false;
                        if(t[0] < 0 || arr_b[1] || arr_b[2]){ // 닫는 위치 오류
                            b = false; break;
                        }
                    }else if(s.charAt(j) == '{'){
                        t[1]++; arr_b[0] = false; arr_b[1] = true; arr_b[2] = false;
                    }else if(s.charAt(j) == '}'){
                        t[1]--; arr_b[1] = false;
                        if(t[1] < 0 || arr_b[0] || arr_b[2]){
                            b = false; break;
                        }
                    }else if(s.charAt(j) == '['){
                        t[2]++; arr_b[0] = false; arr_b[1] = false; arr_b[2] = true;
                    }else if(s.charAt(j) == ']'){
                        t[2]--; arr_b[2] = false;
                        if(t[2] < 0 || arr_b[0] || arr_b[1]){
                            b = false; break;
                        }
                    }
                }

                // 한 칸 회전
                Character c = q.poll();
                q.offer(c);

                // 큐 → 문자열로 변환
                for(int k = 0; k < q.size(); k++){
                    c = q.poll();
                    sb.append(c);
                    q.offer(c);
                }

                s = sb.toString();
                sb.setLength(0); // StringBuilder 초기화

                // 올바르지 않은 경우 플래그 초기화
                if(!b){
                    b = true;
                }else{
                    answer++; // 올바른 경우 카운트 증가
                }
            }
        }

        return answer;
    }
}
