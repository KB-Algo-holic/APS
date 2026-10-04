// 할인 행사
// 투포인터/슬라이딩 윈도우
// https://school.programmers.co.kr/learn/courses/30/lessons/131127

import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        HashMap<String, Integer> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int[] count = new int[want.length + 1];

        for(int i = 0; i < want.length; i++) {
            map.put(want[i], i);
        }

        for(String food : discount) {
            
            int newFood = (int)map.getOrDefault(food, count.length - 1);

            q.offer(newFood);
            count[newFood]++;
            
            if(q.size() >= 10) {
                // count equal number answer++;
                boolean join = true;
                for(int i = 0; i < number.length; i++){
                    if(number[i] != count[i]){
                        join = false;
                        break;
                    }
                }
                
                int front = q.poll();
                count[front]--;

                if(join){
                    answer++;
                }
            }
        }
        
        return answer;
    }

}
