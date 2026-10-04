// LC 239 - Sliding Window Maximum
// 슬라이딩 윈도우, Monotonic Deque 
// https://leetcode.com/problems/sliding-window-maximum/


import java.util.*;

class Solution {

    // Rules
    // 1. Q 맨 앞이 가장 큰 수
    // 2. Q 삽입
    // 루프 돌며 현재 수를 삽입
    // 3. Q 삭제
    // 삽입 시 앞 수가 삽입할 수보다 작다면, 앞 수는 앞으로 제일 클 가능성이 없기에 삭제
    // Q의 크기가 k보다 커진다면 FIFO 기준 삭제
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] answer = new int[n-k+1]; // 0 ~ n-k

        Deque<Integer> q = new ArrayDeque<>();

        for (int i=0; i<n; i++) {
            //System.out.println("index :" + i);
            int num = nums[i];
            //System.out.println("num :" + num);
            while (!q.isEmpty() && nums[q.peekLast()] < num) {
                q.pollLast();
            }
            q.offer(i);
            //System.out.println("before"+ q);
            if (i-k+1 >= 0) {
                answer[i-k+1] = nums[q.peek()];
                
                // 인덱스 삭제
                while (!q.isEmpty() && q.peek() <= i-k+1) {
                    q.poll();
                }

                // 작은 값 삭제
                while (!q.isEmpty() && nums[q.peekLast()] < num) {
                    q.pollLast();
                }
                //System.out.println("answer :" + Arrays.toString(answer));
                
            }
            //System.out.println("after"+ q);
            
        }
    return answer;


    }
}
