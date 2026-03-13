public class PGM_120921_YHS {
    public int solution(String A, String B) {
        int answer = 0;

        String s = A+A;
        int n = A.length();

        if(s.indexOf(B) == -1){
            answer = -1;
        }else if(A.equals(B)){
            answer = 0;
        }else {
            for(int i=n; i>=0; i--){
                if(B.equals(s.substring(i,i+n))){
                    answer = n-i;
                    break;
                }
            }
        }

        return answer;
    }
}
