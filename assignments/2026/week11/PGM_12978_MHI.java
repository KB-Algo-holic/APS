import java.util.*;
class Solution {
    static int[] dist;
    static int[][] tree;
    static HashSet<Integer> set = new HashSet<>();
    static
    public int solution(int N, int[][] road, int K) {

        tree = new int[N+1][N+1];
        dist = new int[N+1];
        for (int i=0; i<=N; i++) dist[i] = Integer.MAX_VALUE;

        for (int[] r: road) {
            if (tree[r[0]][r[1]] == 0 || tree[r[0]][r[1]] > r[2]) {
                tree[r[0]][r[1]] = r[2];
                tree[r[1]][r[0]] = r[2];
            }
        }

        dist[1] = 0;
        makeAns(1, 0, K);

        return set.size();
    }

    static void makeAns(int node, int sum, int K) {
        if (sum > K) return;

        set.add(node);

        for (int i=1; i<tree.length; i++) {
            if (tree[node][i] != 0 && dist[i] > sum+tree[node][i]) {
                dist[i] = sum+tree[node][i];
                makeAns(i, sum+tree[node][i], K);
            }
        }

    }
}