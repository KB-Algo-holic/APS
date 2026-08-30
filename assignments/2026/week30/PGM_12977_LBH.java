// 소수 만들기
// 완전탐색
// https://school.programmers.co.kr/learn/courses/30/lessons/12977

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int[] primes = new int[nums.length * 1000];
        
        primes[1] = 1;
        primes[2] = 1;
        primes[3] = 1;
        for(int i = 4; i < primes.length; i++){
            int isPrime = 1;
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    isPrime = 0;
                    break;
                }
            }
            if(isPrime == 1){
                primes[i] = 1;
            }
        }

        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(primes[nums[i] + nums[j] + nums[k]] == 1){
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}
