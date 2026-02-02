import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {

        Puzzle[] list = new Puzzle[diffs.length];
        for (int i=0; i<diffs.length; i++) {
            list[i] = new Puzzle(diffs[i], times[i]);
        }

        int l = 1;
        int r = 100000;

        while (l < r) {
            int mid = (l + r) / 2;
            long total = 0;
            int prev = 0;

            for (Puzzle p : list) {
                int n = p.diff - mid;
                total += (n > 0) ? (n * (p.time + prev) + p.time) : p.time;
                prev = p.time;
            }

            if (total > limit) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
    static class Puzzle {
        int diff; int time;

        public Puzzle(int diff, int time) {
            this.diff = diff;
            this.time = time;
        }
    }
}