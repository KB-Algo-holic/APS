class Solution {
    boolean solution(String s) {
        int count = 0;
        for (char word : s.toCharArray()) {
            if (word == '(') {
                count++;
            } else {
                count--;
            }

            if (count < 0) return false;
        }

        return count == 0;
    }
}