import java.util.*;
class Solution
{
    public int solution(String s)
    {

        boolean[][] pd = new boolean[s.length()][s.length()];
        for(int i=0; i<s.length(); i++) {
            pd[i][i] = true;
        }
        int max=1;
        if(s.length()==1) return max;

        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i-1)==s.charAt(i)) {
                pd[i-1][i]=true;
                max=Math.max(max, 2);
            }
        }
        for(int i=2; i<s.length(); i++) {
            for(int j=i; j<s.length(); j++){
                if(s.charAt(j-i)==s.charAt(j)&&pd[j-i+1][j-1]){
                    pd[j-i][j]=true;
                    max=Math.max(max, i+1);
                }
            }
        }
        return max;
    }
}