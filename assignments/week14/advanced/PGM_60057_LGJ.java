// PGM 문자열 압축
// 스택? 구현?
// https://school.programmers.co.kr/learn/courses/30/lessons/60057


import java.util.*;

class Solution {
    public static int solution(String s) {
        int min_length = Integer.MAX_VALUE;
        int length = s.length();

        for (int i = 0; i < length/2+1; i++) {
            //System.out.println("devide by : " + i);
            String devideS =  devideByN(s, i, length);
            //System.out.println("result : " + devideS);
            int devideLength = devideS.length();
            if (devideLength < min_length) min_length = devideLength;
        }


        return min_length;
    }

    public static String devideByN(String s, int n, int l) {
        if (n < 1) return s;

        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int cnt = 1;
        for (int start = 0; start<l; start+=n) { // 0, 2, 4, 6
            int end = start + n;
            String temp;
            if (end > l) end = l;
            temp = s.substring(start, end);
            //System.out.println(temp);
            //비교를 위해 stack에 push
            if (stack.isEmpty()) {
                stack.push(temp);
                continue;
            };

            String exString = stack.pop();
            if (exString.equals(temp)) { // 같을 때
                cnt ++;
            } else if (cnt == 1) { // 이전 문자열과 이전 문자열의 개수가 1일 때
                sb.append(exString);
            } else { // 다르고 1 이상일 때
                sb.append(Integer.toString(cnt)+exString);
                cnt = 1;
            }
            stack.push(temp);
        }

        if (!stack.isEmpty()) {
            if (cnt > 1) {
                sb.append(Integer.toString(cnt)+stack.pop());
            } else {
                sb.append(stack.pop());
            }
        }
        return sb.toString();
    }
}