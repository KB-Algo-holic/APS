// PGM_43165 타겟 넘버
// 재귀함수
// school.programmers.co.kr/learn/courses/30/lessons/43165

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = checkSum(numbers, target, 0, 0);
        return answer;
    }
    
    public int checkSum(int[] numbers, int target, int idx,
                       int now_sum){
        if(idx < numbers.length){
            return checkSum(numbers, target, idx + 1, now_sum + numbers[idx]) + 
                checkSum(numbers, target, idx + 1, now_sum - numbers[idx]);
        }
        else{
            if(now_sum == target)
                return 1;
            else
                return 0;
        }
    }
}
