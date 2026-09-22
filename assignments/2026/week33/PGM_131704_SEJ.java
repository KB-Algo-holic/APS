// PGM 택배상자
// Stack, 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/131704


import java.util.*;
class Solution {
    public int solution(int[] order) {
        int result =0;
        
        Stack<Integer> stack = new Stack<>();
        int maxIdx = order.length+1;
        int idx = 0;
        int cur = 1;
        // int tmp = 0;
        
        while(true){
            if(idx>order.length-1) break; 
            // idx 번째를 지금 실을 수 있는가?
            if(order[idx] == cur){ // 가능하다. 기존에 있는 경우
                idx +=1;
                cur+=1;
                result++;
                continue;
            }
            
            if(!stack.isEmpty() && stack.peek()==order[idx]){
                stack.pop();
                idx +=1;
                result++;
                continue;
            }
            
            // 불가능 하다?!
            stack.push(cur);
            cur+=1;
            
            
            if(cur > maxIdx) break;
        }
        
        return result;
    }
}
