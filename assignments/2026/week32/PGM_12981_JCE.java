// https://school.programmers.co.kr/learn/courses/30/lessons/12981

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
    HashMap<String, Integer> map = new HashMap<>();
    map.put(words[0], 1);
    char endAlphabet = words[0].toCharArray()[words[0].length() - 1];
    int num = -1;
    // 단어 전체 순회
    for (int i = 1; i < words.length; i++) {
        String word = words[i];
        // 앞서 말하지 않은 단어인지 체크
        if (map.get(word) != null) {
            num = i;
            break;
        }
        // 첫 알파벳이 이전 끝 알파벳과 같은지 체크
        char firstAlphabet = word.toCharArray()[0];
        if (endAlphabet != firstAlphabet) {
            num = i;
            break;
        }
        endAlphabet = word.toCharArray()[word.length() - 1];
        map.put(word, 1);
    }

    // 가장 먼저 탈락하는 사람의 번호와
    answer[0] = (num % n) + 1;

    // 그 사람이 자신의 몇번째 차례에 탈락하는지
    answer[1] = (num + n) / n;
        return answer;
    }
}
