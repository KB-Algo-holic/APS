// PGM - 43238 L3_입국심사
// 이분탐색
// https://school.programmers.co.kr/learn/courses/30/lessons/43238?language=java
public class PGM_43238_YHS {

    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 0;
        // Arrays.sort(times);
        long right = (long)n * times[0];

        long mid = 0;
        while(left <= right){
            mid = (left + right) / 2;
            if(checkPass(n, times, mid)){
                answer = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return answer;
    }
    private static boolean checkPass(int n, int[] times, long mid) {
        long cnt = 0;
        for(int i=0; i<times.length; i++){
            cnt += mid / times[i];
            if(cnt >= n){
                return true;
            }
        }
        return false;
    }
}
