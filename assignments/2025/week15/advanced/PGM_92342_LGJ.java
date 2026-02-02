import java.util.*;

class Solution {
    int[] answer = new int[11];
    int[] scores = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    int max_gap = 0;

    public int[] solution(int n, int[] apeach) {

        perm(new int[11], n, 0, 0, apeach);

        return max_gap > 0 ? answer : new int[] {-1};
    }

    public void perm(int[] cur, int n, int idx, int cnt, int[] apeach) {

        if (cnt == n) {
            count(apeach, cur);
            return;
        }

        for (int i=idx; i<11; i++) {
            cur[i]++;
            perm(cur, n, i, cnt+1, apeach);
            cur[i]--;
        }

    }

    public void count(int[] apeach, int[] ryan) {
        int apeach_score = 0;
        int ryan_score = 0;

        for (int i=0; i<11; i++) {
            if (apeach[i] == 0 && ryan[i] == 0) continue; // 둘 다 0이면 점수 없음
            if (ryan[i] > apeach[i]) ryan_score += scores[i];
            else apeach_score += scores[i];
        }

        if (ryan_score <= apeach_score) return;

        int gap = ryan_score - apeach_score;
        if (gap > max_gap) {
            max_gap = gap;
            System.arraycopy(ryan, 0, answer, 0, 11);
        } else if (gap == max_gap) {
            // 동점일 때 낮은 점수(인덱스 10→0)에 더 많이 맞힌 배열을 선택
            for (int i = 10; i >= 0; i--) {
                if (ryan[i] == answer[i]) continue;
                if (ryan[i] > answer[i]) {
                    System.arraycopy(ryan, 0, answer, 0, 11);
                }
                break;
            }
        }

    }


}