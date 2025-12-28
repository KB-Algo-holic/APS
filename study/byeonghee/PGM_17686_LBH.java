// PGM 17686 - [3차] 파일명 정렬
// 문자열
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/17686

import java.util.*;

class Solution {

    int[] getIndex(String s){
        int sHeadIndex = 0, sNumberIndex = 0;

        for(int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);

            if('0' <= temp && temp <= '9' && sHeadIndex == 0) {
                sHeadIndex = i;
            }

            if(i == s.length() - 1) {
                sNumberIndex = i + 1;
                break;
            }

            if(sHeadIndex != 0) {
                if(!('0' <= temp && temp <= '9')) {
                    sNumberIndex = i;
                    break;
                }
            }
        }

        return new int[]{sHeadIndex, sNumberIndex};
    }

    public String[] solution(String[] files) {

        List<String> list = new ArrayList<>(Arrays.asList(files));

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int[] s1_indexArray = getIndex(s1);
                int[] s2_indexArray = getIndex(s2);

                String[] s1_elements = {s1.substring(0, s1_indexArray[0]), s1.substring(s1_indexArray[0], s1_indexArray[1])};
                String[] s2_elements = {s2.substring(0, s2_indexArray[0]), s2.substring(s2_indexArray[0], s2_indexArray[1])};

                if(s1_elements[0].compareToIgnoreCase(s2_elements[0]) > 0) {
                    return 1;
                } else if(s1_elements[0].compareToIgnoreCase(s2_elements[0]) < 0){
                    return -1;
                } else {
                    if(Integer.parseInt(s1_elements[1]) > Integer.parseInt(s2_elements[1])) {
                        return 1;
                    } else if(Integer.parseInt(s1_elements[1]) < Integer.parseInt(s2_elements[1])){
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });

        return list.toArray(new String[0]);
    }
}