import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        boolean[] students = new boolean[n + 1];
        boolean[] canBorrow = new boolean[n + 1];
        
        Arrays.fill(students, true);
        
        for (int i = 0; i < lost.length; i++) {
            students[lost[i]] = false;
        }
        
        for (int i = 0; i < reserve.length; i++) {
            canBorrow[reserve[i]] = true;
        }
        
        for (int i = 1; i < students.length; i++) {
            if (!students[i] && canBorrow[i]) {
                students[i] = true;
                canBorrow[i] = false;
            }
        }
        
        for (int i = 1; i < students.length; i++) {
            if (!students[i]) {
                if (canBorrow[i - 1]) {
                    students[i] = true;
                    canBorrow[i - 1] = false;
                    continue;
                } 
                if (i < n && canBorrow[i + 1]) {
                    students[i] = true;
                    canBorrow[i + 1] = false;
                }
            }
        }
        
        for (int i = 1; i < students.length; i++) {
            if (students[i]) answer++;
        }
        
        return answer;
    }
}
