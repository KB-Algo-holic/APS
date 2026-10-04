// LC - 925 Long Pressed Name
// 투포인터
// https://leetcode.com/problems/long-pressed-name/description/
public class LC_925_YHS {
    public boolean isLongPressedName(String name, String typed) {
        boolean answer = true;

        int nSize = name.length();
        int tSize = typed.length();

        if(nSize > tSize) return false;
        if(name.charAt(0) != typed.charAt(0)) return false;
        if(name.charAt(nSize-1) != typed.charAt(tSize-1)) return false;

        int np = 0;
        int tp = 0;

        while(np < nSize && tp < tSize){
            char nc = name.charAt(np);
            char tc = typed.charAt(tp);

            if(nc == tc){
                np++;
                tp++;
            }else if(name.charAt(np-1) == tc){
                tp++;
            }else{
                answer = false;
                break;
            }
        }

        if(np != nSize) answer = false;

        if(answer){
            for(int i=tp; i<tSize; i++){
                if(typed.charAt(i) != name.charAt(nSize-1)){
                    answer = false;
                    break;
                }
            }
        }

        return answer;
    }
}
