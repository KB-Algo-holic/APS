// PGM 43163 단어 변환
// https://school.programmers.co.kr/learn/courses/30/lessons/43163
import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String[]> que = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        que.offer(new String[] {begin, "0"});
        
        while(!que.isEmpty()){
            String[] now = que.poll();
            String nowVal = now[0];
            int transCnt = Integer.parseInt(now[1]);
            for(int i = 0;i < words.length; i++){
                int diff = 0;
                String next = words[i];
                if(nowVal.equals(target))
                    return transCnt;
                if(visited[i])
                    continue;
                for(int n = 0; n < nowVal.length();n++){
                    if(nowVal.charAt(n) != next.charAt(n)){
                        diff++;
                    }
                }
                if(diff == 1){
                    que.offer(new String[]{next, String.valueOf(transCnt + 1)});
                    visited[i] = true;
                }
            }
        
        }
        return 0;
    }
}
