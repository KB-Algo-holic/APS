// [3차] 파일명 정렬
// 정렬
// https://school.programmers.co.kr/learn/courses/30/lessons/17686

import java.util.*;

class Solution {

    public String[] getSplitArray(String x) {

        String[] split = new String[3];

        for(int i = 0; i < x.length(); i++) {
            if(Character.isDigit(x.charAt(i))) {
                // HEAD
                split[0] = x.substring(0, i);

                // NUMBER
                int j = i;
                for(; j < x.length() && j < i + 5; j++) {
                    if(!Character.isDigit(x.charAt(j))) {
                        break;
                    }
                }
                split[1] = x.substring(i, j);

                // TAIL
                if(j + 1 == x.length()) {
                    split[2] = "";
                } else {
                    split[2] = x.substring(j);
                }

                break;
            }
        }

        return split;
    }

    public String[] solution(String[] files) {
        Arrays.sort(files, (a, b) -> {
            String[] aSplitArray = getSplitArray(a);
            String[] bSplitArray = getSplitArray(b);

            String aHead = aSplitArray[0].toLowerCase();
            String bHead = bSplitArray[0].toLowerCase();

            int aNumber = Integer.parseInt(aSplitArray[1]);
            int bNumber = Integer.parseInt(bSplitArray[1]);

            // HEAD
            if(aSplitArray[0].toLowerCase().equals(bSplitArray[0].toLowerCase())) {
                // NUMBER
                if(aNumber == bNumber) {
                    return 0;
                } else {
                    return aNumber - bNumber;
                }
            } else {
                return aHead.compareTo(bHead);
            }
        });

        return files;
    }
}