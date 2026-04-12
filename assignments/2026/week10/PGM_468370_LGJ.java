// PGM - 468370
// 해시 - 문자열
// https://school.programmers.co.kr/learn/courses/30/lessons/468370

import java.util.*;

class WordInfo {
    String text;
    int start, end;

    WordInfo(String text, int start, int end) {
        this.text = text;
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int n = message.length();
        List<WordInfo> wordInfoList = new ArrayList<>();
        int start = 0;

        for (int i=0; i<=n; i++) {
            if (i == n || message.charAt(i) == ' ') {
                String text = message.substring(start, i);
                wordInfoList.add(
                        new WordInfo(text, start, i-1)
                );
                start = i+1;
            }
        }


        // spoiler 문자 표시
        boolean[] isSpoilerChar = new boolean[n];

        for (int[] range : spoiler_ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                isSpoilerChar[i] = true;
            }
        }

        // non-spoiler 영역 등장 단어
        Set<String> normalWords = new HashSet<>();
        Set<String> spoWords = new HashSet<>();
        for (WordInfo w : wordInfoList) {
            boolean isSpoiler = false;
            for (int i = w.start; i <= w.end; i++) {
                if (isSpoilerChar[i]) {
                    spoWords.add(w.text);
                    isSpoiler = true;
                    break;
                }
            }
            if (!isSpoiler) normalWords.add(w.text);
        }

        //System.out.println(normalWords);
        //System.out.println(spoWords);
        spoWords.removeAll(normalWords);

        return spoWords.size();
    }
}