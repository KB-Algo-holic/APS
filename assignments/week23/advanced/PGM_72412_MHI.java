import java.util.*;
class Solution {
    static HashMap<String, ArrayList<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        for (String s : info) {
            String[] arr = s.split(" ");
            int score = Integer.parseInt(arr[4]);
            makeKey(arr, "", 0, score);
        }

        for (ArrayList<Integer> list : map.values()) {
            Collections.sort(list);
        }

        int[] answer = new int[query.length];
        for (int i=0; i<query.length; i++) {
            String q = query[i].replaceAll(" and ", " ");
            String[] arr = q.split(" ");
            String key = arr[0] + arr[1] + arr[2] + arr[3];
            int score = Integer.parseInt(arr[4]);

            if (map.containsKey(key)) {
                ArrayList<Integer> list = map.get(key);
                int idx = findIdx(list, score);
                answer[i] = list.size() - idx;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }

    public void makeKey(String[] arr, String str, int depth, int score) {
        if (depth == 4) {
            map.computeIfAbsent(str, k -> new ArrayList<>()).add(score);
            return;
        }
        makeKey(arr, str + arr[depth], depth + 1, score);
        makeKey(arr, str + "-", depth + 1, score);
    }

    public int findIdx(ArrayList<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
