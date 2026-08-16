// 덧칠하기
// 그리디
// https://school.programmers.co.kr/learn/courses/30/lessons/161989

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int once = 0;
        
        for(int i = 0; i < section.length; i++){
            if(once == 0){
                once = section[i] + m;
                answer++;
            } else if(once > section[i]){
                continue;
            } else {
                once = 0;
                i-=1;                
            }
        }
        
        return answer;
    }
}
