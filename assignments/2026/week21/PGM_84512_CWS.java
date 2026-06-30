// PGM 84512 - 모음사전
// DFS/BFS
// https://school.programmers.co.kr/learn/courses/30/lessons/84512

import java.util.*;

class Solution {
    public int solution(String words) {

        char[] word = {'A','E','I','O','U'};

        HashMap<String, Integer> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int num = 1;

        for(int i = 0; i < 5; i++){
            sb.append(word[i]);
            hm.put(sb.toString(), num++);
            for(int j = 0; j < 5; j++){
                sb.append(word[j]);
                hm.put(sb.toString(), num++);
                for(int k = 0; k < 5; k++){
                    sb.append(word[k]);
                    hm.put(sb.toString(), num++);
                    for(int l = 0; l < 5; l++){
                        sb.append(word[l]);
                        hm.put(sb.toString(), num++);
                        for(int m = 0; m < 5; m++){
                            sb.append(word[m]);
                            hm.put(sb.toString(), num++);
                            sb.deleteCharAt(sb.length()-1);
                        }
                        sb.deleteCharAt(sb.length()-1);
                    }
                    sb.deleteCharAt(sb.length()-1);
                }
                sb.deleteCharAt(sb.length()-1);
            }
            sb.deleteCharAt(sb.length()-1);
        }

        return hm.get(words);
    }
}