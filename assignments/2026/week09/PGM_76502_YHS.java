// PGM - 76502 괄호 회전하기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/76502

import java.util.Stack;

public class PGM_76502_YHS {
    public int solution(String s) {
        int answer = 0;

        String ns = "";
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length()-1; i++){

            ns = s.substring(i) + s.substring(0, i);
            stack.clear();
            boolean flag = false;

            for(int j=0; j<ns.length(); j++){
                char c = ns.charAt(j);
                if(c == '(' || c == '{' || c == '['){
                    stack.push(c);
                    flag = true;
                }else{
                    if(c == ')'){
                        if(stack.isEmpty() || stack.peek() != '('){
                            continue;
                        }else{
                            stack.pop();
                        }
                    }else if(c == '}'){
                        if(stack.isEmpty() || stack.peek() != '{'){
                            continue;
                        }else{
                            stack.pop();
                        }
                    }else{
                        if(stack.isEmpty() || stack.peek() != '['){
                            continue;
                        }else{
                            stack.pop();
                        }
                    }
                }
            }

            if(flag && stack.isEmpty()){
                // System.out.println(ns);
                answer++;
            }
        }
        return answer;
    }
}
