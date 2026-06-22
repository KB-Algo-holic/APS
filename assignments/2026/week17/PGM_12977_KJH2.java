// PGM_12977 소수 만들기
// 구현
// school.programmers.co.kr/learn/courses/30/lessons/12977
class Solution {
    public int solution(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        for(int i = 0;i < n; i++){
            for (int j = i + 1; j < n ; j++){
                for (int k = j + 1; k < n; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    int sqrts = (int) Math.sqrt(sum);
                    Boolean chk = true;
                    for(int x = 2; x <= sqrts; x++){
                        if(sum % x == 0){
                            chk = false;
                            break;
                        }
                    }
                    if(chk)
                        cnt++;
                }
            }
        }
        return cnt;
    }
}
