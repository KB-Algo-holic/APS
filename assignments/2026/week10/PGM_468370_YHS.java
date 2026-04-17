// PGM - 468370 중요한 단어를 스포 방지
// 해시
// https://school.programmers.co.kr/learn/courses/30/lessons/468370

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PGM_468370_YHS {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        // Map<String, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        // 스포방지 인덱스 저장
        for(int i=0; i<spoiler_ranges.length; i++){
            for(int j=spoiler_ranges[i][0]; j<=spoiler_ranges[i][1]; j++){
                set.add(j);
            }
        }

        Map<String, Integer> words = new HashMap<>();
        Map<String, Integer> hiddenWords = new HashMap<>();

        // for문 돌면서 스포방지 단어인지 아닌지 판별
        int s = 0;
        boolean flag = false;
        for(int i=0; i<message.length(); i++){
            char c = message.charAt(i);
            if(c !=' ' && set.contains(i)){
                flag = true;
            }

            if(c == ' '){
                String word = message.substring(s,i);

                if(flag){
                    hiddenWords.put(word, 1);
                }else{
                    words.put(word, 1);
                }

                s = i+1;
                flag = false;
            }
        }
        for(int i=s; i<message.length(); i++){
            char c = message.charAt(i);

            if(set.contains(i)){
                flag = true;
            }
        }

        String word = message.substring(s);

        if(flag){
            hiddenWords.put(word, 1);
        }else{
            words.put(word, 1);
        }

        for(String key : hiddenWords.keySet()){
            if(words.get(key) == null){
                words.put(key, 1);
                answer++;
            }
        }
        return answer;
    }
}
