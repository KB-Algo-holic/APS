// PGM_84512 모음사전
// 가중치배열 만들어서 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/84512

class Solution {
    public int solution(String word) {
        int answer = 0;
        String dic = "AEIOU";
        int[] weights = new int[5];
        weights[4] = 1;
        for(int i = 3; i >= 0; i--){
            weights[i] = weights[i+1] * 5 + 1;
        }
        for(int i = 0; i < word.length(); i++){
            answer = answer + dic.indexOf(word.charAt(i)) *
                weights[i] + 1;
        }
        return answer;
    }
}
