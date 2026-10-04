// https://school.programmers.co.kr/learn/courses/30/lessons/150370
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] temp = term.split(" ");
            map.put(temp[0].charAt(0), Integer.parseInt(temp[1]) * 28);
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] temp = privacies[i].split(" ");
            int expiredDate = getDays(temp[0]) + map.get(temp[1].charAt(0));
            if (getDays(today) >= expiredDate) list.add(i + 1);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    private static int getDays(String date) {
        String[] temp = date.split("\\.");
        int year = Integer.parseInt(temp[0]);
        int month = Integer.parseInt(temp[1]);
        int day = Integer.parseInt(temp[2]);

        int total = (year * 12 + month) * 28 + day;

        return total;
    }
}
