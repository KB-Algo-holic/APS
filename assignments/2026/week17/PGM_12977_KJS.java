// PGM 12977 - 소수 만들기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/12977?language=java

class Solution {
    public int solution(int[] nums) {
    	// 소수의 개수를 세기 위한 count 선언
        int count = 0;
        
        // 세 가지 수를 더하는 조합
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    // 세 수의 합
                    int num = nums[i] + nums[j] + nums[k];
                    // 소수 판별 후 count 증가
                    if (isPrime(num)) count += 1;
                }
            }
        }

        return count;
    }
    
    // 소수 판별 메서드
    private boolean isPrime(int num) {
        if (num == 2) return true;
        
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
