// 모의고사
// PGM - 17689 [3차]파일명 정렬
// 문자열
// https://school.programmers.co.kr/learn/courses/30/lessons/17686

import java.util.*;

class Solution {

    public String[] solution(String[] files) {
        Map<String, String> file_head = new HashMap<>();
        Map<String, Integer> file_num = new HashMap<>();
        Map<String, String> file_tail = new HashMap<>();

        for (int i=0; i<files.length; i++) {
            String file = files[i];
            String head = "";
            String num = "";
            String tail = "";
            int startIdx = 0;
            int endIdx = file.length();

            // idx 확인
            for (int j=0; j<file.length(); j++) {
                if (Character.isDigit(file.charAt(j))) {
                    // 숫자 시작
                    startIdx = j;
                    for (int k=j+1; k<file.length(); k++) {
                        Character ch = file.charAt(k);
                        if (!Character.isDigit(ch)) {
                            endIdx = k-1;
                            break;
                        }
                    }
                    break;
                }
            }
            // 종료
            head = file.substring(0, startIdx).toLowerCase();
            num = file.substring(startIdx, Math.min(endIdx+1, file.length()));
            //tail = file.substring(endIdx+1, file.length());
            //System.out.println("head:" +head + "\n" + "num:" + num + "\n" + "tail:" + tail);
            file_head.put(file, head);
            file_num.put(file, Integer.parseInt(num));
            //file_tail.put(file, tail);

        }
        // System.out.println(file_head);
        // System.out.println(file_num);
        // System.out.println(file_tail);


        Arrays.sort(files, (a, b) -> {
            if (file_head.get(a).equals(file_head.get(b))) {
                return file_num.get(a).compareTo(file_num.get(b));
            } else {
                return file_head.get(a).compareTo(file_head.get(b));
            }
        });


        return files;
    }
}