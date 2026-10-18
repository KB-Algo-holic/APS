// LC 2397 - Maximum Rows Covered by Columns
// DFS 조합
// https://leetcode.com/problems/maximum-rows-covered-by-columns/description/

class Solution {
    int n;
    int m;
    int[] s;
    int answer=0;
    public int maximumRows(int[][] matrix, int numSelect) {
        n = matrix.length;
        m = matrix[0].length;

        s = new int[numSelect]; // 0~m-1 중 numSelect개 뽑기
        selectCols(0, 0, matrix, numSelect);
        return answer;
    }
    private void selectCols(int depth, int start, int[][] matrix, int numSelect) {

        if (depth == numSelect) {
            //System.out.println(Arrays.toString(s));
            Set<Integer> selected = new HashSet<>();
            for (int c: s) selected.add(c);
            answer = Math.max(answer, coverCols(matrix, selected));
            return;
        }

        for (int i=start; i<m; i++) {
            s[depth] = i;
            selectCols(depth+1, i+1, matrix, numSelect);
        }
    }

    private int coverCols(int[][] matrix, Set<Integer> selected) {
        //System.out.println(selected);
        int total = 0;

        for (int r=0; r<n; r++) {
            boolean covered = true;
            for (int c=0; c<m; c++) {
                if (matrix[r][c] == 1 && !selected.contains(c)) {
                    covered = false;
                    break;
                }
            }
            if (covered) total ++;
        }

        return total;
    }
}