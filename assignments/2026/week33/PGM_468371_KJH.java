// PGM 12914 - 노란불신호등
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/468371


class Solution {
public long solution(int[][] signals) {
        int n = signals.length;
        int[] T = new int[n];
        
        for (int i = 0; i < n; i++) {
            T[i] = signals[i][0] + signals[i][1] + signals[i][2];
        }

        // 모든 신호등 주기의 최소공배수(LCM) 계산
        long maxTime = T[0];
        for (int i = 1; i < n; i++) {
            maxTime = lcm(maxTime, T[i]);
        }

        // 1번 신호등이 노란불이 켜지는 시각들만 순회
        int g0 = signals[0][0];
        int y0 = signals[0][1];
        int t0 = T[0];

        // 1번 신호등의 주기(k) 단위로 노란불 구간 검사
        for (long k = 0; k * t0 <= maxTime; k++) {
            for (int offset = g0; offset < g0 + y0; offset++) {
                long t = k * t0 + offset + 1; // 1-based 초

                if (t > maxTime) break;

                // 나머지 신호등들도 노란불인지 확인
                boolean allYellow = true;
                for (int i = 1; i < n; i++) {
                    long rem = (t - 1) % T[i];
                    if (rem < signals[i][0] || rem >= signals[i][0] + signals[i][1]) {
                        allYellow = false;
                        break;
                    }
                }

                if (allYellow) {
                    return t;
                }
            }
        }

        return -1;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
}
