import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int[] dR = {1, 0, -1, 0};
    static int[] dC = {0, -1, 0, 1};
    public static int solution(int[][] board) {


        Queue<Road> que = new LinkedList<Road>();
        int[][] min = new int[board.length][board.length];
        que.add(new Road(0,0,0,0));
        que.add(new Road(0,0,3,0));
        for(int i=0; i<board.length; i++) Arrays.fill(min[i], Integer.MAX_VALUE);
        min[0][0]=0;
        while(!que.isEmpty()) {
            Road now = que.poll();
            if(now.r==board.length-1&&now.c==board.length-1) continue;
            for(int i=0; i<4; i++) {
                int nextR = now.r+dR[i];
                int nextC = now.c+dC[i];
                if(0<=nextR&&nextR<board.length&&0<=nextC&&nextC<board.length&&board[nextC][nextR]==0) {
                    int nextCost = now.way==i ? now.cost+100 : now.cost+600;
                    if(min[nextC][nextR]>=nextCost) {
                        min[nextC][nextR]=nextCost;
                        que.add(new Road(nextR, nextC, i, nextCost));
                    }
                }
            }
        }
        int answer = min[board.length-1][board.length-1];
        return answer;
    }
    static class Road {
        int r, c, way, cost;
        public Road(int r, int c, int way, int cost) {
            this.r=r;
            this.c=c;
            this.way=way;
            this.cost=cost;
        }
    }
}