class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        
        answer = shift(A,A,B,0);
        
        return answer;
    }
    
    public int shift(String OA,String A,String B,int count)
    {
        if(count !=0 && OA.equals(A))
        {
            return -1;
        }
        if(A.equals(B))
        {
            return count;
        }
        
        String shift_A = A.substring(A.length()-1) + A.substring(0,A.length()-1);
        return shift(OA,shift_A,B,count+1);
        
    }
}
