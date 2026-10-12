// 올바른 괄호 - 12909
// 스택
// https://school.programmers.co.kr/learn/courses/30/lessons/12909
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int a = 0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '(')
            {
                a++;
            }
            else
            {
                if(a == 0)
                {
                    return false;
                }
                a--;
            }
        }
        
        if(a != 0)
            return false;
        else
            return true;
    }
}
