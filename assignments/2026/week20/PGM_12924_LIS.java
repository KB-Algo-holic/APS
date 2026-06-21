// PGM 12924 - 숫자의 표현
// 학습  
// https://school.programmers.co.kr/learn/courses/30/lessons/12924
class Solution {

    public int solution(int n) {
        int[] prefixSum = new int[n + 1]; 
        
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + i;
        }

        int left  = 0;
        int right = 1;
        int count = 0;
        
        while (left < right) {
            int sum = prefixSum[right] - prefixSum[left];

            if (sum < n) right++;
            else {
                if (sum == n) count++;
                left++;
            }
        }

        return count;
    }

}
