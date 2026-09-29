// LC - 844 backspace-string-compare
// 스택 or 투포인터
// https://leetcode.com/problems/backspace-string-compare/?utm_source=chatgpt.com


import java.util.*;
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        for (char c: s.toCharArray()) {
            if (c == '#') {
                if (!stackS.isEmpty()) stackS.pop();
                continue;
            } 
            stackS.add(c);

        }
        for (char c: t.toCharArray()) {
            if (c == '#') {
                if (!stackT.isEmpty()) stackT.pop();
                continue;
            } 
            if (c != '#') stackT.add(c);

        }
        if (stackS.size() != stackT.size()) return false;

        for (int i=0; i<stackS.size(); i++) {
            if (stackS.get(i) != stackT.get(i)) return false;
        }

        return true;

    }
}
