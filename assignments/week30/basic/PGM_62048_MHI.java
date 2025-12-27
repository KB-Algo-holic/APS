class Solution {
    public long solution(int w, int h) {
        long total = (long) w * h;
        long cnt = w + h;

        int max = Math.max(w, h);
        int min = Math.min(w, h);

        int num = gcd(max, min);
        cnt -= num;

        return total - cnt;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
