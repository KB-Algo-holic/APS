// PGM 12977 - 소수 만들기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/12977?language=java

public class PGM_12977_PST {
    class Solution {
        public int solution(int[] nums) {
            int answer = 0;
            int len = nums.length;

            for (int i = 0; i < len - 2; i++) {
                for (int j = i + 1; j < len - 1; j++) {
                    for (int k = j + 1; k < len; k++) {
                        int sum = nums[i] + nums[j] + nums[k];
                        if (isPrime(sum)) {
                            answer++;
                        }
                    }
                }
            }
            return answer;
        }

        private boolean isPrime(int num) {
            if (num < 2) return false;

            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}