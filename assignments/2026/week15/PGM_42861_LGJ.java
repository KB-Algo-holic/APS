// PGM - 42861 섬연결하기
// Union find
// https://school.programmers.co.kr/learn/courses/30/lessons/42861

import java.util.*;
class Solution {
    public int solution(int n, int[][] edges) {// [n1, n2, cost]

        int answer = 0;
        int[] parents = new int[n];
        for (int i=0; i<n; i++) parents[i] = i;

        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        //System.out.println(Arrays.deepToString(edges));

        for (int i=0; i<edges.length; i++) {

            int n1 = edges[i][0];
            int n2 = edges[i][1];
            int c = edges[i][2];

            if (find(n1, parents) != find(n2, parents)) {
                union(n1, n2, parents);
                answer += c;
            }

        }
        return answer;
    }

    int find(int x, int[] parents) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x], parents);
    }

    void union(int x, int y, int[] parents) {
        int rootX = find(x, parents);
        int rootY = find(y, parents);

        if (rootX != rootY) {
            parents[rootY] = rootX;
        }
    }


}