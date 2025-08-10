import java.util.ArrayList;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (check(s, i)) answer++;
        }
        return answer;
    }

    public boolean check(String s, int i) {
        String temp = s.substring(i) + s.substring(0, i);
        ArrayList<Character> st = new ArrayList<>();

        for (char c : temp.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                st.add(c);
            } else if (st.isEmpty()) {
                return false;
            } else if ((st.get(st.size() - 1) == '(' && c == ')')
                    || (st.get(st.size() - 1) == '[' && c == ']')
                    || (st.get(st.size() - 1) == '{' && c == '}')) {
                st.remove(st.size() - 1);
            } else {
                return false;
            }
        }
        return st.isEmpty();
    }
}