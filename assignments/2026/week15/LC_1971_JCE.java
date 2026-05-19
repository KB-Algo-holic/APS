/*
 * LC 1971 Find if Path Exists in Graph
 * https://leetcode.com/problems/find-if-path-exists-in-graph/description/
 */
class Solution {

    static int[] parent;

    public static void main(String[] args) {

        int n = 3;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 0}
        };
        int source = 0;
        int destination = 2;

        System.out.println(validPath(n, edges, source, destination));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];

            union(a, b);
        }

        return find(source) == find(destination);
    }

    private static void union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    private static int find(int a) {

        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }

        return parent[a];
    }
}
