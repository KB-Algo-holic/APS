// PGM 84512 - 모음사전
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/84512?language=java

public class PGM_84512_PST {
    public int solution(String word) {
        int answer = 0;

        int[] rates = new int[5];
        int currentWeight = 0;

        for (int i = 4; i >= 0; i--) {
            currentWeight = currentWeight * 5 + 1;
            rates[i] = currentWeight;
        }

        String vowels = "AEIOU";
        for (int i = 0; i < word.length(); i++) {
            answer += vowels.indexOf(word.charAt(i)) * rates[i] + 1;
        }

        return answer;
    }
}
