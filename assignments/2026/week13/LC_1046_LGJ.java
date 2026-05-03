// LC 1046 - last stone weight
// 우선순위큐
// https://leetcode.com/problems/last-stone-weight/description/

class Solution {
    public int lastStoneWeight(int[] stones) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone: stones) pq.offer(stone);

        while (pq.size() >= 2) {
            int y = pq.poll();
            int x = pq.poll();
            if (x != y) pq.offer(y-x);
        }

        return pq.size() == 0 ? 0 : pq.poll();
    }
}