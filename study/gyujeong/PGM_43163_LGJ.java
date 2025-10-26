import java.util.*;

public class PGM_43163_LGJ {

    class Solution {

        public int solution(String begin, String target, String[] words) {
            int answer = 0;
            int n = begin.length();
            Set<String> used = new HashSet<>();
            Queue<Map<String, Integer>> q = new ArrayDeque<>();
            Map<String, Integer> map = new HashMap<>();
            map.put(begin, 0);
            q.offer(map);


            while (!q.isEmpty()) {
                Map<String, Integer> cur = q.poll();
                //System.out.println(cur);
                String curWord = cur.keySet().iterator().next();
                Integer curCnt = cur.get(curWord);

                if (curWord.equals(target)) {
                    answer = curCnt;
                    break;
                }
                for (String word: words) {
                    if (used.contains(word)) continue;

                    if (isPossibleToChange(n, curWord, word)) {
                        Map<String, Integer> next = new HashMap<>();
                        next.put(word, curCnt+1);
                        q.offer(next);
                        used.add(word);
                    }
                }
            }
            return answer;
        }

        // 하나 빼곤 다 맞아야 변경이 가능함
        public boolean isPossibleToChange(int n, String origin, String compare) {
            int cnt = 0;
            for (int i=0; i<n; i++) {
                if (origin.charAt(i) == compare.charAt(i)) cnt ++;
            }
            return cnt == n-1;
        }
    }
}
