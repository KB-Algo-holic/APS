import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemSet = new HashSet<>(Arrays.asList(gems));
        int n = gems.length;

        int s = 0;
        int l = 0, r = n;

        while (l <= r) {
            int mid = (l + r) / 2;
            Map<String, Integer> temp = new HashMap<>();
            int start = 0;
            boolean found = false;

            for (int i = 0; i < n; i++) {
                temp.put(gems[i], temp.getOrDefault(gems[i], 0) + 1);

                if (i >= mid) {
                    String leftGem = gems[start];
                    temp.put(leftGem, temp.get(leftGem) - 1);
                    if (temp.get(leftGem) == 0) temp.remove(leftGem);
                    start++;
                }

                if (temp.size() == gemSet.size()) {
                    s = start;
                    r = mid - 1;
                    found = true;
                    break;
                }
            }

            if (!found) l = mid + 1;
        }

        return new int[] { s + 1, s + l };
    }
}
