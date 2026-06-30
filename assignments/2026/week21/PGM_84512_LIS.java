// PGM 84512 - 모음사전
// 학습  
// https://school.programmers.co.kr/learn/courses/30/lessons/84512?language=java
import java.util.*;

class Solution {
    static String s;
    static ArrayList<String> list = new ArrayList<>();
    public int solution(String word) {
        s = "AEIOU";
        for(int i = 1; i <=5; i++){
            duple_permutation(i, 0, new char [5]);
        }
        Collections.sort(list);
        return list.indexOf(word) + 1;
    }

    public void duple_permutation(int r, int depth, char [] answer) {
        if(depth == r) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < r; i ++){
                sb.append(answer[i]);
            }
            list.add(sb.toString());
            return;
        }

        for(int i = 0; i < s.length(); i++){
            answer[depth] = s.charAt(i);
            duple_permutation(r, depth+1, answer);
        }
    }
}
