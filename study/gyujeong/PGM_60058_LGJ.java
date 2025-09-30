// PGM 괄호변환
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/60058
import java.util.*;

public class PGM_60058_LGJ {

    class Solution {
        public String solution(String p) {
            if (isRight(p)) return p;
            return fixString(p);
        }

        public String fixString(String w) {
            if (w.length() == 0) return "";
            StringBuilder result = new StringBuilder();
            String[] uv = splitUAndV(w);
            String u = uv[0];
            String v = uv[1];

            if (isRight(u)) {
                //u가 올바른 문자열
                return u + fixString(v);
            } else {
                result.append("(");//4-1
                result.append(fixString(v));//4-2
                result.append(")");

                for (int i=0; i<u.length(); i++) {
                    if (i == 0 || i == u.length()-1) continue;
                    if (u.charAt(i) == '(') result.append(')');
                    else if (u.charAt(i) == ')') result.append('(');

                }

                return result.toString();
            }

        }

        boolean isBalanced(String s) {
            int cnt1 = 0;
            int cnt2 = 0;
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '(') cnt1 ++;
                else if (s.charAt(i) == ')') cnt2 ++;
            }
            return cnt1 == cnt2;
        }

        boolean isRight(String s) {
            Stack<String> stack = new Stack<>();
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '(') stack.push(String.valueOf(s.charAt(i)));
                else if (!stack.isEmpty()) {
                    if ("(".equals(stack.peek())) stack.pop();
                    else stack.push(String.valueOf(s.charAt(i)));

                }
            }
            //System.out.println(stack);

            return stack.size() == 0;
        }

        String[] splitUAndV(String s) {
            String[] uv = new String[2];
            int cnt1 = 0;
            int cnt2 = 0;

            for (int i=0; i<s.length(); i++) {
                if ('(' == s.charAt(i)) cnt1 ++;
                else cnt2 ++;
                if (cnt1 == cnt2) {
                    uv[0] = s.substring(0, i+1);
                    uv[1] = s.substring(i+1, s.length());
                    break;
                }
            }
            return uv;
        }
    }
}
