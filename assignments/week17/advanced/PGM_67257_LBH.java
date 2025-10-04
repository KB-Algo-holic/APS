// PGM 67257 - 수식 최대화
// 큐, 스택
// https://school.programmers.co.kr/learn/courses/30/lessons/67257

import java.util.*;

class Solution {
    
    Deque<String> main = new ArrayDeque<>();
    Deque<String> sub = new ArrayDeque<>();
    List<String> oriList = new ArrayList<>();
    
    long run(String seq) {
        
        for(String oriStr : oriList) {
            main.offer(oriStr);
        }
        
        for(int i = 0; i < 3; i++) {
            while(main.size() > 0) {
                String element = main.poll();
                
                if(element.charAt(0) == seq.charAt(i)) {
                    String first = sub.pop();
                    String second = main.poll();
                    
                    if('+' == seq.charAt(i)) {
                        sub.push(Long.toString(Long.parseLong(first) + Long.parseLong(second)));
                    } else if('-' == seq.charAt(i)) {
                        sub.push(Long.toString(Long.parseLong(first) - Long.parseLong(second)));
                    } else if('*' == seq.charAt(i)) {
                        sub.push(Long.toString(Long.parseLong(first) * Long.parseLong(second)));
                    }
                } else {
                    sub.push(element);
                }
            }
            
            while(sub.size() > 0) {
                main.offer(sub.pop());
            }
            
            List<String> list = new ArrayList<>(main);
            Collections.reverse(list);
            main = new ArrayDeque<>(list);
        }
        
        return Math.abs(Long.parseLong(main.poll()));
    }
    
    public long solution(String expression) {
        long answer = 0;
        
        String temp = "";
        for(int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                oriList.add(temp);
                oriList.add("" + expression.charAt(i));
                temp = "";
            } else {
                temp += expression.charAt(i);
            }
        }
        oriList.add(temp);
        
        long result = 0;
        
        result = run("+-*");
        if(result > answer) {
            answer = result;
        }
        
        result = run("+*-");
        if(result > answer) {
            answer = result;
        }
        
        result = run("-+*");
        if(result > answer) {
            answer = result;
        }
        
        result = run("-*+");
        if(result > answer) {
            answer = result;
        }
        
        result = run("*+-");
        if(result > answer) {
            answer = result;
        }
        
        result = run("*-+");
        if(result > answer) {
            answer = result;
        }
        
        return answer;
    }
}
