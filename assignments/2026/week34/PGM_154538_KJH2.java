// PGM 154538 숫자 변환하기
// https://school.programmers.co.kr/learn/courses/30/lessons/154538
import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];
        queue.offer(new int[] {x, 0});
        visited[x] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int now = cur[0];
            int cnt = cur[1];
            
            if(now == y){
                return cnt;
            }
            
            int[] next = {
                now + n,
                now * 2,
                now * 3
            };
            
            for(int num : next){
                if(num > y){
                    continue;
                }
                if(visited[num]){
                    continue;
                }
                
                queue.offer(new int[]{num, cnt + 1});
                visited[num] = true;   
            }
        }
        
        return -1;
    }
}
