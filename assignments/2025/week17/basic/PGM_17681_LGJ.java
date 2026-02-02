// PGM - 비밀지도
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/17681

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i=0; i<n; i++) {
            StringBuilder row1 = new StringBuilder(Integer.toString(arr1[i], 2));
            while (row1.length() < n) row1.insert(0, "0");
            StringBuilder row2 = new StringBuilder(Integer.toString(arr2[i], 2));
            while (row2.length() < n) row2.insert(0, "0");

            StringBuilder sb = new StringBuilder();
            for (int j=0; j<n; j++) {
                if (row1.charAt(j) == '0' && row2.charAt(j) == '0') sb.append(" ");
                else sb.append("#");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}