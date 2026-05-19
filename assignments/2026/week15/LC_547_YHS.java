// LC - 547 Number of Provinces
// BFS
// https://leetcode.com/problems/number-of-provinces/description/
import java.util.LinkedList;
import java.util.Queue;

public class LC_547_YHS {
    public int findCircleNum(int[][] isConnected) {
        int answer = 0;
        int size = isConnected.length;
        boolean isVisited[] = new boolean[size];

        for(int n=0; n<size; n++){
            if(!isVisited[n]){
                answer++;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(n);
                isVisited[n] = true;

                while(!queue.isEmpty()){
                    int front = queue.poll();

                    for(int i=0; i<size; i++){
                        if(!isVisited[i] && isConnected[front][i] == 1){
                            isVisited[i] = true;
                            queue.offer(i);
                        }
                    }
                }
            }
        }

        return answer;
    }
}
