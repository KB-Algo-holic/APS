// 괄호 변환
// 구현, 스택
// https://school.programmers.co.kr/learn/courses/30/lessons/60058

import java.util.*;

class Solution {
    
    public Boolean correct(String u) {
        Stack<Character> open = new Stack<>();
        
        for(int i = 0; i < u.length(); i++) {
            if('(' == u.charAt(i)) {
                open.push('(');
            } else {
                if(open.size() == 0) {
                    return false;
                } else {
                    open.pop();
                }
            }
        }
        
        return true;
    }
    
    public String convert(String w) {
        // 1
        if(w.length() == 0) {
            return w;
        }
        
        // 2
        String u = "", v = "";
        int lCnt = 0, rCnt = 0;
        for(int i = 0; i < w.length(); i++) {
            if('(' == w.charAt(i)) {
                lCnt++;
            } else {
                rCnt++;
            }
            
            if(lCnt == rCnt) {
                u = w.substring(0, i + 1);
                v = w.substring(i + 1, w.length());
                break;
            }
        }
        
        // 3
        if(correct(u)) {
            return u + convert(v);
        }
        
        // 4
        String newU = "";
        for(int i = 1; i < u.length() - 1; i++) {
            if('(' == u.charAt(i)) {
                newU += ')';
            } else {
                newU += '(';
            }
        }
        
        return "(" + convert(v) + ")" + newU;
    }
    
    public String solution(String p) {
        return convert(p);
    }
}
