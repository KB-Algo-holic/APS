import java.util.*;

class Solution{
    public int solution(String s){
        Stack<Character> stack = new Stack<>();
        
        if(s.length()%2==1) return 0;   // 홀수인 경우는 모두 제거될 수 없다.

        for(char ch : s.toCharArray()){
            if(stack.isEmpty()){
                // 스택이 비어 있다? -> 넣는다.
                stack.push(ch);
                continue;
            }
            
            // stack의 맨 위에 있는 값이 지금 나랑 같은가?
            char top = stack.peek();
            if(top == ch){  // 짝이 맞다
                stack.pop();    // 뽑아서 제거
            }else{
                stack.push(ch);
            }
        }
        
        if(stack.isEmpty()) return 1;
        
        // stack을 한번 순회하면서 짝이 있는게 있는지 본다
        char pre = stack.pop();
        while(!stack.isEmpty()){
            char cur = stack.peek();
            if(cur == pre){
                pre = cur;
                stack.pop();
            }else{
                break;
            }
        }
            

        return stack.isEmpty()?1:0;
    }
}