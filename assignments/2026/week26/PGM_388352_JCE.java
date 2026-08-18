import java.util.*;

class Solution {
    static int N, R;
    static int[] input;
    static int[] numbers;
    static int[][] sQ;
    static int[] sAns;
    static int answer;

    public static int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        N = n;
        R = q[0].length;
        numbers = new int[R];
        input = new int[n];
        sQ = q;
        sAns = ans;
        for (int i = 0; i < n; i++) {
            input[i] = i + 1;
        }
        combination(0, 0);
        return answer;
    }

    public static void combination(int cnt, int start) {
        if (cnt == R) {
            int[] matchCnt = new int[sQ.length];
            for (int i = 0; i < sQ.length; i++) {
                matchCnt[i] = equalCnt(numbers, sQ[i]);
            }

            if (Arrays.equals(matchCnt, sAns)) {
                answer++;
            }
            return;
        }

        for (int i = start; i < N; i++) {
            numbers[cnt] = input[i];
            combination(cnt + 1, i + 1);
        }
    }

    private static int equalCnt(int[] arr1, int[] arr2) {
        int cnt = 0;

        Set<Integer> set = new HashSet<>();
        for (int n : arr1) {
            set.add(n);
        }

        for (int n : arr2) {
            if (set.contains(n)) cnt++;
        }

        return cnt;
    }
}
