import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n] ;
        String lpad = "%" + n +"s";
        
        for(int aa=0; aa < n; aa++) {
            String str1 = Integer.toBinaryString(arr1[aa]);
            String str2 = Integer.toBinaryString(arr2[aa]);
            
            String lPadStr1 = String.format(lpad, str1).replace(" ", "0");
            String lPadStr2 = String.format(lpad, str2).replace(" ", "0");
            
            String lineStr = "";
            for(int bb=0; bb<n; bb++) {
                if(lPadStr1.charAt(bb) == '0' && lPadStr2.charAt(bb) == '0') {
                    lineStr = lineStr + " ";
                } else {
                    lineStr = lineStr + "#";
                }
            }
            answer[aa] = lineStr;
        }
        
        return answer;
    }
}