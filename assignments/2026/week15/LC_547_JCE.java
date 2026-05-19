/*
 * LC 547. Number of Provinces
 * https://leetcode.com/problems/number-of-provinces/
 */
class Solution {
    
    private static int[] parent;

    public static int findCircleNum(int[][] isConnected) {

        int answer = 0;

        int n = isConnected.length;

        parent = new int[n];

        // 자기 자신이 부모
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 연결된 원소끼리 union
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        // 최종 대표 부모 카운트
        for (int i = 0; i < n; i++) {

            if (find(i) == i) {
                answer++;
            }
        }

        return answer;
    }

    // 두 그룹 합치기
    private static void union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    // 최상위 부모 찾기
    private static int find(int a) {

        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }

        return parent[a];
    }
}
