// PGM 12977 - 소수만들기
// 유형: 완전탐색
// https://school.programmers.co.kr/learn/courses/30/lessons/12977?language=java

class Solution {
    int[] selected = new int[3]; // 3개를 고를거임
    int result = 0;
    int N;
    
    public int solution(int[] nums) {
        N = nums.length;
        comb(0,0,nums,0);  
        return result;
    }
    
    public void comb(int start, int idx, int[] nums, int sum){
        
        if(idx ==3){
            // 답이 될 수 있는지 판단
            if(isPossible(sum)) result++;
            return;
        }
        
        //3개 고를거임, 순서 상관 X, 중복 X
        for(int i=start;i<nums.length;i++){
            selected[idx] = nums[i];
            comb(i+1, idx+1, nums, sum+nums[i]);
        }
    }
    
    // 소수인지 아닌지 판단하는 함수
    public boolean isPossible(int n){
        for(int i=2; i<n;i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}