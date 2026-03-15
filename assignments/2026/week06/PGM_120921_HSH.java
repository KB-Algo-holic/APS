package week06;

public class PGM_120921_HSH {
    public static void main(String[] args) {
        PGM_120921_HSH sol = new PGM_120921_HSH();
    
        int result = sol.solution("hello", "ohell");
    
        System.out.println(result);
    }    
    public int solution(String A, String B){
        int inx = 0;
        String doubleB = B + B; // oellhoellhoellh
        if(A.length() != B.length()) return -1;
        if(doubleB.contains(A)){
            inx = doubleB.indexOf(A);
        } else {
            return -1;
        }
        return inx;
    }
}
