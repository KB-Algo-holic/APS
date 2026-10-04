// PGM 176963 - 추억점
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/176963
import java.util.HashMap;
import java.util.Map;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> scoreMap = new HashMap<>();
 
        for (int i = 0; i < name.length; i++) {
            scoreMap.put(name[i], yearning[i]);
        } 
        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (String person : photo[i]) {
                sum += scoreMap.getOrDefault(person, 0);
            }
            answer[i] = sum;
        }

        return answer;
    }
}
