// PGM 12977 소수만들기
// 완전탐색 - 조합 및 소수확인
// https://school.programmers.co.kr/learn/courses/30/lessons/12977


import java.util.*;

class Solution {
    int answer = 0;
    public int solution(int[] nums) {

        comb(0, 0, new int[3], nums);
        return answer;
    }

    // 조합
    void comb(int start, int depth, int[] cur, int[] nums) {
        if (depth == 3) {
            //System.out.println(Arrays.toString(cur));
            int sum = cur[0]+cur[1]+cur[2];
            if (isPrime(sum)) {
                //System.out.println(sum);
                answer++;
            }
            return;
        }

        for (int i=start; i<nums.length; i++) {
            cur[depth] = nums[i];
            comb(i+1, depth+1, cur, nums);
        }
    }

    // 소수 판별
    boolean isPrime(int num) {
        for (int i=2; i<=Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

}