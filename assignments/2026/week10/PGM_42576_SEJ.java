// PGM - 42576 완주하지 못한 선수
// 해시
// https://school.programmers.co.kr/learn/courses/30/lessons/42576

import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        
        for(String p : participant){
            map.put(p, map.getOrDefault(p,0)+1);   
        }
        
        for(String c : completion){
            int cnt = map.get(c)-1;
            if(cnt>0){
                map.put(c, cnt);
                continue;
            }
            map.remove(c);
        }
        
        String result = "";
        for(String p : participant){
            if(!map.containsKey(p)) continue;
            result = p;
        }
        
        return result;
    }
}