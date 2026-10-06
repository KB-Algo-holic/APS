// PGM 120861 - 캐릭터의 좌표
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/120861?language=java


import java.util.*;

class Solution {
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};
        
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        int w = board[0] / 2;
        int h = board[1] / 2;
        
        Map<String, Integer> map = new HashMap<>();
        map.put("right", 0);
        map.put("left", 1);
        map.put("up", 2);
        map.put("down", 3);
        
        for (String dir: keyinput) {
            int d = map.get(dir);
            int nr = answer[0] + dr[d];
            int nc = answer[1] + dc[d];
            
            if (nr < w*(-1) || nr > w || nc < h*(-1) || nc > h) continue;
            answer[0] = nr;
            answer[1] = nc;
        }
        
        
        return answer;
    }
}
