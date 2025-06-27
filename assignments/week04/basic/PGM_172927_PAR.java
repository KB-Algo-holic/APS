# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 172927 - 광물 캐기
# 유형: 그리디
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/172927

import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = Integer.MAX_VALUE;
        int[][] memo = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        
        int[] nums = new int[minerals.length];
        for(int i = 0; i < minerals.length; i++) {
            if("diamond".equals(minerals[i])) {
                nums[i] = 0;
            } else if("iron".equals(minerals[i])) {
                nums[i] = 1;
            } else if("stone".equals(minerals[i])) {
                nums[i] = 2;
            }
        }
        
        PriorityQueue<Memorize> pq = new PriorityQueue<>();
        pq.offer(new Memorize(0, 0, picks));
        
        while(!pq.isEmpty()) {
            Memorize m = pq.poll();
            int[] arr = new int[3];
            int length = Math.min(minerals.length, m.n + 5);
            
            if(m.n >= minerals.length) {
                answer = Math.min(answer, m.k);
                continue;
            }
            
            for(int i = m.n; i < length; i++) {
                for(int j = 0; j < 3; j++) {
                    if(m.picks[j] > 0) {
                        arr[j] += memo[j][nums[i]];
                    }
                }
            }
            
            boolean sw = true;
            for(int i = 0; i < 3; i++) {
                if(arr[i] > 0) {
                    sw = false;
                    int[] newPicks = Arrays.copyOf(m.picks, 3);
                    newPicks[i]--;
                    pq.offer(new Memorize(m.k + arr[i], m.n + 5, newPicks));
                }
            }
            
            if(sw) {
                answer = Math.min(answer, m.k);
            }
        }
        
        return answer;
    }
    
    private class Memorize implements Comparable<Memorize> {
        int k, n;
        int[] picks;
        
        public Memorize(int k, int n, int[] picks) {
            this.k = k;
            this.n = n;
            this.picks = picks;
        }
        
        @Override
        public int compareTo(Memorize o) {
            if(this.k == o.k) {
                if(this.picks[0] == o.picks[0]) {
                    if(this.picks[1] == o.picks[1]) {
                        return Integer.compare(o.picks[2], this.picks[2]);
                    }
                    return Integer.compare(o.picks[1], this.picks[1]);
                }
                return Integer.compare(o.picks[0], this.picks[0]);
            }
            return Integer.compare(this.k, o.k);
        }
        
        public void print() {
            System.out.println(k + " " + n + " " + Arrays.toString(picks));
        }
    }
}