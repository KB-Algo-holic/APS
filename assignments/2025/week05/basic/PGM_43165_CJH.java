// PGM 43165 - 타겟 넘버
// 유형 : DFS
// 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43165

class Solution {
    public int solution(int[] numbers, int target) {
        int sum = 0;
        int answer = 0;
        for (int number : numbers) {
            sum += number;
        }
        int x = sum / 2;

        for (int i = 0; i < numbers.length; i++) {
            sum = x * 2;
            if (numbers[i] <= x) {
                for (int j = i; j < numbers.length; j++) {
                    sum -= numbers[j];
                    if (sum == target) {
                        answer++;
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}