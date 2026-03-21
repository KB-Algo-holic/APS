// PGM 12973 - 짝지어 제거하기
// 문자열
// https://school.programmers.co.kr/learn/courses/30/lessons/12973

import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Deque<Character> q = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            //q가 비어있으면 입력
            if(q.isEmpty()){
                q.offer(s.charAt(i));
            }else{
                //q가 비어있지 않고 입력할 문자와 맨 앞 문자가 같으면 제거
                if(q.peekLast() == s.charAt(i)){
                    q.pollLast();
                }else{
                //q가 비어있지 않지만 입력할 문자와 다르면 입력
                    q.offer(s.charAt(i));
                }
            }
        }

        if(q.isEmpty()) return 1;
        else return 0;
    }
}