// PGM 155651 - 호텔대실
// 그리디
// https://school.programmers.co.kr/learn/courses/30/lessons/155651

import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] time = new int[60*61];

        for(int i = 0; i < book_time.length; i++){
            int start = Integer.parseInt(book_time[i][0].substring(0,2)) * 60 + Integer.parseInt(book_time[i][0].substring(3,5));
            int end = Integer.parseInt(book_time[i][1].substring(0,2)) * 60 + Integer.parseInt(book_time[i][1].substring(3,5));
            for(int j = start; j < end+10; j++){
                time[j]++;
            }
        }
        for(int i = 0; i < time.length; i++){
            if(answer < time[i]) answer = time[i];
        }
        return answer;
    }
}