class Solution {
    publiSolutionc int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        for(int i = m; i>0; i--){
            int a = n%i;
            int b = m%i;
            if(a ==0 && b ==0) {
                answer[0] = i;
                break;
            }
        }
        answer[1] = n*m / answer[0];
        return answer;
    }
}