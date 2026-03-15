package BOJ;
import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int nextInt() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    static class Solution {
        public int solution(int a, int b) {
            return a + b;
        }
    }

    public static void main(String[] args) throws Exception {
        int a = nextInt();
        int b = nextInt();

        Solution sol = new Solution();
        System.out.println(sol.solution(a, b));
    }
}