import java.util.*;
class Solution {
    static int[] parent;
    public int solution(int n, int[][] computers) {
        parent = new int[n];
        for (int i=0; i<n; i++) parent[i] = i;

        for (int i=0; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (computers[i][j] == 1) {
                    int parentI = findRoot(i);
                    int parentJ = findRoot(j);

                    if (parentI < parentJ) parent[parentJ] = parentI;
                    else if (parentJ < parentI) parent[parentI] = parentJ;
                }
            }
        }
        int answer = 0;
        for (int i=0; i<n; i++) if (parent[i] == i) answer ++;
        return answer;
    }
    public int findRoot(int i) {
        if (parent[i] == i) return i;
        return parent[i] = findRoot(parent[i]);
    }
}