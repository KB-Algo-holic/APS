// PGM 12924 - 숫자의표현
// 투포인터/슬라이딩윈도우
// https://school.programmers.co.kr/learn/courses/30/lessons/12924

class Solution {
    public int solution(int n) {
        int answer = 1;
        int l = 1;
        int r = 1;
        int sum = 1;

        while(true){
            if(r == n)
                break;

            if(sum == n){
                answer++;
                sum -= l;
                l++;
            }else if(sum > n){
                sum -= l;
                l++;
            }else{
                r++;
                sum += r;
            }

        }

        return answer;
    }
}