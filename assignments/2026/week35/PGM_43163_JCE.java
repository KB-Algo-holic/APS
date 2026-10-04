/*
- BFS
- https://school.programmers.co.kr/learn/courses/30/lessons/43163
*/

import java.util.*;

class WordObject {
    String word;
    int changeCnt;
    
    WordObject(String word, int changeCnt) {
        this.word = word;
        this.changeCnt = changeCnt;
    }
    
}
class Solution {
    public int solution(String begin, String target, String[] words) {
        
        // words에 target 없으면 바로 리턴
        boolean thereis = false;
        for (String word : words) {
            if (target.equals(word)) thereis = true;
        }
        if (!thereis) return 0;

        boolean[] visited = new boolean[words.length];
        Queue<WordObject> queue = new LinkedList<>();
        queue.offer(new WordObject(begin, 0));
        
        while(!queue.isEmpty()) {
            WordObject cur = queue.poll();
            if (cur.word.equals(target)) return cur.changeCnt;
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isOneDiff(cur.word, words[i])) {
                    queue.offer(new WordObject(words[i], cur.changeCnt + 1));
                    visited[i] = true;
                }
            }
        }
        return 0;
    }
    
    private boolean isOneDiff(String a, String b) {
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        
        int cnt = 0;
        for (int i = 0; i < aArr.length; i++) {
            if (aArr[i] != bArr[i]) cnt++;
        }
        return cnt == 1;
    }
}
