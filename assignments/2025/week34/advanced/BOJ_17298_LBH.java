// BOJ 17298 - 오큰수
// 스택
// https://www.acmicpc.net/problem/17298

import java.io.*;
import java.util.*;

class Main {

    public static int[] solution(int N, int[] nums) {
        int[] result = new int[N];
        Arrays.fill(result, -1);

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerLast(new int[]{nums[0], 0});

        for(int i = 1; i < N; i++) {
            int num = nums[i];

            while(!deque.isEmpty() && deque.peekLast()[0] < num) {
                int[] prev = deque.pollLast();
                result[prev[1]] = num;
            }

            deque.offerLast(new int[]{num, i});
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] ret = solution(N, nums);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(ret[i]).append(' ');
        }
        System.out.print(sb.toString());
    }
}
