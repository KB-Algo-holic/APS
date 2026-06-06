// PGM 42862 - 체육복
// 학습  
// https://school.programmers.co.kr/learn/courses/30/lessons/42862
import java.util.*;
class Solution {

    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n];
        Arrays.fill(student, 1);

        // 도난
        for (int i = 0; i < lost.length; i++) {
          student[lost[i]-1] = student[lost[i]-1] - 1;
        } 

        // 여벌 
        for (int i = 0; i < reserve.length; i++ ) {
            student[reserve[i]-1] = student[reserve[i]-1] + 1;  
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            // 체육복이 없는 경우
            if (student[i] == 0) {
                // 앞 학생에게 빌릴 수 있는 경우
                if (i > 0 && student[i - 1] == 2) {
                    student[i]++;
                    student[i - 1]--;
                }
                // 뒷 학생에게 빌릴 수 있는 경우
                else if (i < n - 1 && student[i + 1] == 2) {
                    student[i]++;
                    student[i + 1]--;
                }
            }

            // 체육복이 있는 학생이면 수업 가능
            if (student[i] > 0) count++;
        }

        return count;
    }
}
