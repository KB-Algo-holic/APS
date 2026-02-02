import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = bridge_length;
        int temp = 0, t = 1;
        Deque<int[]> cross = new ArrayDeque<>();
        
        for(int i = 0; i < truck_weights.length; i++) {
            while(!cross.isEmpty() && (cross.size() >= bridge_length || temp + truck_weights[i] > weight || cross.peek()[1] + bridge_length == t)) {
                int[] arr = cross.poll();
                temp -= arr[0];
                t = arr[1] + bridge_length;
            }
            
            cross.add(new int[] {truck_weights[i], t++});
            temp += truck_weights[i];
        }
        
        answer += cross.pollLast()[1];
        return answer;
    }
}