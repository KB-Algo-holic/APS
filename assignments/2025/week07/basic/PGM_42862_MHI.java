class Solution {
    boolean[] give;
    boolean[] receive;
    int answer = 0;
    public int solution(int n, int[] lost, int[] reserve) {

        give = new boolean[n];
        receive = new boolean[n];
        int plus = 0;

        for (int i=0; i<n; i++) receive[i] = true;
        for (int i : lost) receive[i-1] = false;
        for (int i : reserve) {
            if (!receive[i-1]) receive[i-1] = true;
            else give[i-1] = true;
        }
        for (int i=0; i<n; i++) if (receive[i]) plus ++;

        makeAns(0, 0, n);

        return answer + plus;
    }

    public void makeAns(int i, int total, int n) {
        if (i == n) {
            answer = Math.max(answer, total);
            return;
        }

        if (give[i] && i > 0 && !receive[i-1]) {
            receive[i-1] = true;
            makeAns(i+1, total+1, n);
            receive[i-1] = false;
        }

        if (give[i] && i < n - 1 && !receive[i+1]) {
            receive[i+1] = true;
            makeAns(i+1, total+1, n);
            receive[i+1] = false;
        }

        makeAns(i+1, total, n);
    }
}