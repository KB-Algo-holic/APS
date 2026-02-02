import java.util.*;
class Solution {
    public int[] solution(int[][] dice) {

        HashMap<int[], Integer> map = new HashMap<>();
        for (int i=0; i<dice.length; i++) {
            map.put(dice[i], i);
        }

        Arrays.sort(dice, (a, b) -> {
            int cnt = 0;
            for (int i=0; i<6; i++) {
                for (int j=0; j<6; j++) {
                    cnt += b[j] - a[i];
                }
            }
            return cnt == 0 ? map.get(a) - map.get(b) : cnt;
        });

        int[] answer = new int[dice.length / 2];
        for (int i=0; i<answer.length; i++) {
            answer[i] = map.get(dice[i]) + 1;
        }
        Arrays.sort(answer);

        return answer;
    }
}