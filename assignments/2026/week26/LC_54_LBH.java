// Spiral Matrix
// 구현
// https://leetcode.com/problems/spiral-matrix/

import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int times = matrix.length * matrix[0].length;
        
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int r = 0, c = -1, move = 0;
        while(times-- > 0) {
            int newR = r + dir[move][0];
            int newC = c + dir[move][1]; 
            if(0 <= newR && newR < matrix.length && 0 <= newC && newC < matrix[0].length) {
                if(matrix[newR][newC] == 999) {
                    move += 1;
                    move %= 4;
                }
            } else {
                move += 1;
                move %= 4;
            }
            
            newR = r + dir[move][0];
            newC = c + dir[move][1]; 

            list.add(matrix[newR][newC]);
            matrix[newR][newC] = 999;

            r = newR;
            c = newC;
        }

        return list;
    }
}
