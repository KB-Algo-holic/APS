class Solution {

    public String[] solution(int n, int[] arr1, int[] arr2) {

        int[] ans = new int[n];

        for(int i=0; i<n; i++) {
            ans[i] = arr1[i]|arr2[i];
        }

        char[][] map = new char[n][n];

        String[] answer = new String[n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {

                if((ans[i]&(1<<j))>0) {
                    map[i][n-1-j]='#';
                }
                else map[i][n-1-j]=' ';
            }
            answer[i] = String.valueOf(map[i]);
        }
        return answer;
    }
}