import java.util.*;
class Solution {
    static int[] parent;

    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        parent = new int[n];

        for (int i=0; i<n; i++) parent[i] = i;
        int answer = 0;
        for (int[] link : costs) {
            int a = link[0];
            int b = link[1];
            int cost = link[2];

            int parentA = findRoot(a);
            int parentB = findRoot(b);

            if (parentA != parentB) {
                answer += cost;
                if (parentA < parentB) parent[parentB] = parentA;
                else if (parentA > parentB) parent[parentA] = parentB;
            }
        }
        return answer;
    }

    public int findRoot(int a) {
        if (parent[a] == a) return a;
        return parent[a] = findRoot(parent[a]);
    }
}