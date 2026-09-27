// PGM 12977 - 소수만들기
// 학습
// https://school.programmers.co.kr/learn/courses/30/lessons/12977
class Solution {
    static int answer;
    static int N;

    public int solution(int[] nums) {
        answer = 0;
        N = nums.length;
        back_tracking(0, 0, 0, nums);
        return answer;
    }


    static void back_tracking(int idx, int cnt, int sum, int[] nums) {
        
        if (cnt == 3) {
            if (is_prime(sum)) {
                answer++;
            }
            return;
        }

        
        if (idx >= N || cnt + (N-idx) < 3) return;


        
        back_tracking(idx+1, cnt+1, sum + nums[idx], nums);

        
        back_tracking(idx+1, cnt, sum, nums);
    }
    
    static boolean is_prime(int sum) {
        int res = 0;
        for (int i = 1; i < sum+1; i++) {
            if (sum % i == 0) res++;
        }

        if (res == 2) return true;

        return false;
    }


}
