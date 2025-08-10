import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] multi = new int[] {28 * 12, 28, 1};
        int time = 0;
        int i = 0;
        for (String word : today.split("\\.")) {
            time += Integer.parseInt(word) * multi[i];
            i++;
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : terms) {
            String[] info = word.split(" ");
            map.put(info[0], Integer.parseInt(info[1]));
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int num=0; num<privacies.length; num++) {
            String word = privacies[num];

            i = 0;
            String[] info = word.split(" ");
            int endTime = 0;
            for (String d : info[0].split("\\.")) {
                endTime += Integer.parseInt(d) * multi[i];
                i ++;
            }

            endTime += map.get(info[1]) * multi[1];
            if (time >= endTime) {
                list.add(num + 1);
            }
        }

        int[] answer = new int[list.size()];
        for (i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}