import java.util.*;

class Solution {
    boolean[] isVisited;
    int result = (int)1e9;
    
    public int solution(int x, int y, int n) {
        isVisited = new boolean[y+1];
        bfs(x, y, n);
        return result == (int)1e9 ? -1 : result;
    }
    
    public void bfs(int x, int y, int n){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, 0});
        isVisited[x] = true;
        
        while(!q.isEmpty()){
            int[] ints = q.poll();
            
            int num = ints[0];
            int depth = ints[1];
            
            if(num>y) break;
            
            if(num == y) {
                System.out.println("값 찾아땅!!! " + depth);
                result = Math.min(result, depth);
                break;
            }
            
            // 갈 수 있다? 간다.
            
            // x+n
            if(num+n <= y && !isVisited[num+n]){
                isVisited[num+n] = true;
                q.add(new int[]{num+n, depth+1});
            }
            
            if(num*2 <= y && !isVisited[num*2]){
                isVisited[num*2] = true;
               q.add(new int[]{num*2, depth+1});
            }
            
            if(num*3 <= y && !isVisited[num*3]){
                isVisited[num*3] = true;
               q.add(new int[]{num*3, depth+1});
            }
        }
    }
}
