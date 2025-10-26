class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        for (char c : s.toCharArray()) {
            int i = 0;
            char tmp = c;
            while (i < index) {
                tmp++;
                if (tmp > 'z') tmp = 'a';

                if (!skip.contains(String.valueOf(tmp))) i++;
            }
            answer += String.valueOf(tmp);
        }
        return answer;
    }
}