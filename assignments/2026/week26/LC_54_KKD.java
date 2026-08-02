// Spiral Matrix
// 구현
// https://leetcode.com/problems/spiral-matrix/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int length_Max = matrix.length * matrix[0].length;
        int x_Max = matrix.length - 1;
        int y_Max = matrix[0].length - 1;
        int x = 0;
        int y = 0;

        boolean[][] visited = new boolean[x_Max + 1][y_Max + 1];
        int flag = 0;

        while (result.size() < length_Max) {
            result.add(matrix[x][y]);
            visited[x][y] = true;

            switch (flag) {
                case 0: 
                    if (y == y_Max || visited[x][y+1]) {
                        flag = 1;
                        x++;
                    } else {
                        y++;
                    }
                    break;
                case 1: //아래
                    if (x == x_Max || visited[x+1][y]) {
                        flag = 2;
                        y--;
                    } else {
                        x++;
                    }
                    break;
                case 2: //역방향
                    if (y == 0 || visited[x][y-1]) {
                        flag = 3;
                        x--;
                    } else {
                        y--;
                    }
                    break;
                case 3: //위
                    if (x == 0 || visited[x-1][y]) {
                        flag = 0;
                        y++;
                    } else {
                        x--;
                    }
                    break;
            }
        }
        return result;
    }
}
