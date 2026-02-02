// PGM - 괄호 회전하기
// 구현 스택
// https://school.programmers.co.kr/learn/courses/30/lessons/76502
// 두 가지 풀이



import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        Map<String, String> map = new HashMap<>();
        map.put(")", "(");
        map.put("}", "{");
        map.put("]", "[");
        //System.out.println(map);

        for (int i=0; i<n; i++) {
            Stack<String> stack = new Stack<>();
            int cnt = 0;

            // start from i
            while (cnt < n) {
                int idx = i+cnt >= n ? (i+cnt) % n : (i+cnt);
                String cur = String.valueOf(s.charAt(idx));
                if (stack.isEmpty()) stack.push(cur);
                else {
                    if (map.getOrDefault(cur, "").equals(stack.peek())) stack.pop();
                    else stack.push(cur);
                }
                cnt ++;
            }
            //System.out.println(stack);
            if (stack.isEmpty()) answer ++;


        }


        return answer;
    }
}

/*
import java.util.*;

class Solution {
    public static int solution(String s) {
        int answer = 0;
        int length = s.length();
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < length; i++) {
            if (i >= 1) {
                // 맨 앞 문자 추출
                char firstChar = sb.charAt(0);
                // 맨 앞 문자 제거
                sb.deleteCharAt(0);
                // 맨 뒤에 추가
                sb.append(firstChar);
            }

            if (isRight(String.valueOf(sb), length)) {
                answer += 1;
            }
        }
        return answer;
    }

    public static boolean isRight(String s, int length) {
        //System.out.println("origin" + s);
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (deque.isEmpty()) {
                if (c == ')' || c == '}' || c == ']') { return false; }
                deque.addLast(c);
            } else {
                char top = deque.peekLast();
                if (c == ')' && top == '(') {
                    deque.pollLast();
                } else if (c == '}' && top == '{') {
                    deque.pollLast();
                } else if (c == ']' && top == '[') {
                    deque.pollLast();
                } else {
                    deque.addLast(c);
                }
            }
        }
        //System.out.println("result" + Arrays.toString(deque.toArray()));
        return deque.isEmpty();
    }
}


*/