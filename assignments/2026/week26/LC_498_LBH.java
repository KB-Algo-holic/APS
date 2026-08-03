// Diagonal Traverse
// 구현
// https://leetcode.com/problems/diagonal-traverse/

import java.util.*;

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        List<Integer> list = new ArrayList<>();
        int times = mat.length * mat[0].length;
        
        int[][] dir = {{-1, 1}, {1, -1}};
        int r = 1, c = -1, move = 0;
        while(list.size() < times) {
            int newR = r + dir[move][0];
            int newC = c + dir[move][1]; 
            
            if(!(0 <= newR && newR < mat.length && 0 <= newC && newC < mat[0].length)) {
                if(!(0 <= r && r < mat.length && 0 <= c && c < mat[0].length)) {
                    newR = newR + dir[move][0];
                    newC = newC + dir[move][1];
                } else {
                    if(move == 0) {
                        newC++;
                        move = 1;
                    } else {
                        newR++;
                        move = 0;
                    }
                }
            }

            if(0 <= newR && newR < mat.length && 0 <= newC && newC < mat[0].length) {
                list.add(mat[newR][newC]);
            }
            
            r = newR;
            c = newC;
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
