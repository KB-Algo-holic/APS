import java.util.LinkedList;
import java.util.Queue;

public class PGM_42583_YHS {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> wait = new LinkedList<>();

        for(int i=0; i<bridge_length; i++){ // 다리에 빈공간 채우기
            bridge.offer(0);
        }

        int total = 0;
        for(int i=0; i<truck_weights.length; i++){
            wait.offer(truck_weights[i]);
            total += truck_weights[i];
        }

        int sum = 0;

        while(total > 0){
            int head = bridge.poll();

            // 1. 한칸 전진.
            total -= head;
            // 2. 다리무게 감소
            sum -= head;
            // 3-1. 다음 대기트럭 올릴수 있을때
            if(!wait.isEmpty() && sum+wait.peek() <= weight){
                int newTruck = wait.poll();
                bridge.offer(newTruck);
                sum += newTruck;
            }
            // 3-2. 다음 대기트럭 올릴수 없을때
            else{
                bridge.offer(0); // 빈공간 채우기
            }
            // 시간초 증가
            answer++;
        }

        return answer;
    }
}
