// PGM 76502 - 괄호 회전하기
// 유형: 이분탐색
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/76502

import java.util.*;

class Solution {
    public int solution(String s) {

        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[6];
        int answer = 0;
        int num = s.length();
        boolean b = true;
        boolean[] arr_b = new boolean[3];

        // 각 괄호의 개수를 세어 저장
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

        // 괄호의 개수가 짝이 맞을 때만 검사 진행
        if(arr[0] == arr[1] && arr[2] == arr[3] && arr[4] == arr[5]){
            for(int i = 0; i < num; i++){
                int[] t = new int[3]; // 각 괄호 스택 카운트 역할

                for(int j = 0; j < num; j++){
                    if(s.charAt(j) == '('){
                        arr_b[0] = true; arr_b[1] = false; arr_b[2] = false;
                        t[0]++;
                    }else if(s.charAt(j) == ')'){
                        t[0]--;
                        arr_b[0] = false;
                        // 괄호 순서가 잘못되었거나 열림 괄호가 없음
                        if(t[0] < 0 || arr_b[1] || arr_b[2]){
                            b = false;
                            break;
                        }
                    }else if(s.charAt(j) == '{'){
                        t[1]++; arr_b[0] = false; arr_b[1] = true; arr_b[2] = false;
                    }else if(s.charAt(j) == '}'){
                        t[1]--; arr_b[1] = false;
                        if(t[1] < 0 || arr_b[0] || arr_b[2]){
                            b = false;
                            break;
                        }
                    }else if(s.charAt(j) == '['){
                        t[2]++; arr_b[0] = false; arr_b[1] = false; arr_b[2] = true;
                    }else if(s.charAt(j) == ']'){
                        t[2]--; arr_b[2] = false;
                        if(t[2] < 0 || arr_b[0] || arr_b[1]){
                            b = false;
                            break;
                        }
                    }
                }

                // 맨 앞 문자를 뒤로 보냄
                Character c = q.poll();
                q.offer(c);

                for(int k = 0; k < q.size(); k++){
                    c = q.poll();
                    sb.append(c);
                    q.offer(c);
                }

                s = sb.toString();
                sb.setLength(0);

                if(!b){
                    b = true;
                }else{
                    answer++;
                }

            }
        }

        return answer;
    }
}
