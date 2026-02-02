class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        int length = s.length();
        int start = (int) 'a';
        int end = (int) 'z';

        for (int i=0; i<length; i++) {
            int cnt = 0;
            char c = s.charAt(i);
            int code = (int) c;
            while (cnt < index) {
                code++;

                if (code > end) code = start;

                char tmp = (char) code;
                if (!skip.contains(String.valueOf(tmp))) cnt++;
            }

            answer.append((char) code);

        }

        return answer.toString();
    }
}