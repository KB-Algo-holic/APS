import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] ans1 = {1, 2, 3, 4, 5};
        int[] ans2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] ans3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        for (int i=0; i<answers.length; i++) {
            if (ans1[ i % ans1.length] == answers[i]) {
                count1 ++;
            }
            if (ans2[ i % ans2.length] == answers[i]) {
                count2 ++;
            }
            if (ans3[ i % ans3.length] == answers[i]) {
                count3 ++;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        if (Math.max(count1, Math.max(count2, count3)) == count1) list.add(1);
        if (Math.max(count1, Math.max(count2, count3)) == count2) list.add(2);
        if (Math.max(count1, Math.max(count2, count3)) == count3) list.add(3);

        return list.stream().mapToInt(i -> i).toArray();
    }
}