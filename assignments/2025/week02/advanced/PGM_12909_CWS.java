class Solution {
    boolean solution(String s) {
        int cnt = 0;
        boolean answer = true;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                cnt++;
            }else{
                cnt--;
            }
            if(cnt < 0){
                answer = false;
                break;
            }
        }

        if(cnt != 0){
            answer = false;
        }

        return answer;
    }
}