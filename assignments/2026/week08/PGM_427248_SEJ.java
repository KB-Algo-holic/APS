// PGM-42748 K번째수
// 정렬
// https://school.programmers.co.kr/learn/courses/30/lessons/42748

import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        for(int i=0;i<commands.length;i++){
            //System.out.println("원본배열 = "+Arrays.toString(array));
            //배열 자르기
            int[] arr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            // System.out.println(Arrays.toString(arr));
            Arrays.sort(arr);
            //System.out.println(Arrays.toString(arr));
            result[i] = arr[commands[i][2]-1];
        }
        
        return result;
    }
}