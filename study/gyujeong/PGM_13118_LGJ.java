import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        HashMap<Integer, Integer> xMap = new HashMap<>();
        HashMap<Integer, Integer> yMap = new HashMap<>();

        for (int i=0; i<10; i++) {
            xMap.put(i, 0);
            yMap.put(i, 0);
        }

        for (int i=0; i<X.length(); i++) {
            int num = Character.getNumericValue(X.charAt(i));
            xMap.put(num, xMap.get(num)+1);
        }

        for (int i=0; i<Y.length(); i++) {
            int num  = Character.getNumericValue(Y.charAt(i));
            yMap.put(num, yMap.get(num)+1);
        }

        for (int i=9; i>=0; i--) {
            int cnt = Math.min(xMap.get(i), yMap.get(i));
            if (cnt == 0) continue;
            for (int c=0; c<cnt; c++) {
                answer.append(i);
            }
            if (i==0 && answer.toString().length() == cnt) return "0";
        }


        return answer.toString().length() > 0 ? answer.toString() : "-1";
    }
}