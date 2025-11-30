import java.util.*;

class Solution {

    Map<String, Integer> countMap;
    int maxCount;

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = new String(arr);
        }

        for (int c : course) {
            countMap = new HashMap<>();
            maxCount = 0;

            for (String order : orders) {
                makeComb(order, "", 0, c);
            }

            for (String key : countMap.keySet()) {
                if (countMap.get(key) == maxCount && maxCount >= 2) {
                    answer.add(key);
                }
            }
        }

        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    private void makeComb(String order, String cur, int idx, int target) {
        if (cur.length() == target) {
            countMap.put(cur, countMap.getOrDefault(cur, 0) + 1);
            maxCount = Math.max(maxCount, countMap.get(cur));
            return;
        }
        if (idx >= order.length()) return;

        makeComb(order, cur + order.charAt(idx), idx + 1, target);
        makeComb(order, cur, idx + 1, target);
    }
}