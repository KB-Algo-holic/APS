class Solution {
    public int solution(String A, String B) {
        for(int i = 0; i < A.length(); i++){
            if(A.equals(B)) return i;
            A = A.charAt(A.length()-1) + A.substring(0, A.length()-1);
        }
        return -1;
    }
}
