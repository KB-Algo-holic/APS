class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {

        int start = h1 * 3600 + m1 * 60 + s1;
        int end   = h2 * 3600 + m2 * 60 + s2;

        int answer = 0;

        int vH = 1;
        int vM = 12;
        int vS = 720;
        int MOD = 360 * 120;

        int dH = (start * (vS - vH)) % MOD;
        int dM = (start * (vS - vM)) % MOD;

        int add = 0;
        if (dH == 0 && dM == 0) add += 1;
        else if (dH == 0 || dM == 0) add += 1;

        while (start < end) {

            boolean hitH = dH + (vS - vH) >= MOD;
            boolean hitM = dM + (vS - vM) >= MOD;

            if (hitH && hitM) {
                if ((MOD - dH) * (vS - vM) == (MOD - dM) * (vS - vH)) add += 1;
                else add += 2;
            } else if (hitH || hitM) {
                add += 1;
            }

            answer += add;

            dH = (dH + (vS - vH)) % MOD;
            dM = (dM + (vS - vM)) % MOD;
            add = 0;
            start++;
        }

        return answer;
    }
}
