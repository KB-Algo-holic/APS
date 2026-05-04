package week12;

public class PGM_86971_HSH {
    public static void main(String[] args) {
        PGM_86971_HSH sol = new PGM_86971_HSH();

        int n = 7;
        int[][] wires = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}};

        int result = sol.solution(n, wires);
        System.out.println("최소 차이: " + result);
    }

    public int solution(int n, int[][] wires) {
        int minDifference = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            // 전선을 하나씩 제거
            int[][] modifiedWires = new int[wires.length - 1][2];
            for (int j = 0, k = 0; j < wires.length; j++) {
                if (j != i) {
                    modifiedWires[k++] = wires[j];
                }
            }

            // 제거된 전선으로 인해 두 개의 트리가 형성됨
            int count1 = countNodes(modifiedWires, wires[i][0], new boolean[n + 1]);
            int count2 = n - count1;

            // 두 트리의 노드 수 차이 계산
            minDifference = Math.min(minDifference, Math.abs(count1 - count2));
        }

        return minDifference;
    }

    private int countNodes(int[][] wires, int start, boolean[] visited) {
        visited[start] = true;
        int count = 1;

        for (int[] wire : wires) {
            if (wire[0] == start && !visited[wire[1]]) {
                count += countNodes(wires, wire[1], visited);
            } else if (wire[1] == start && !visited[wire[0]]) {
                count += countNodes(wires, wire[0], visited);
            }
        }

        return count;
    }
}