// PGM 340213 동영상재생기
// https://school.programmers.co.kr/learn/courses/30/lessons/340213
// 구현


import java.util.*;
import java.io.*;
class Solution {
    StringTokenizer st;
    int totalLength;
    int opStart;
    int opEnd;
    int cur;
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        totalLength = convertToSec(video_len);
        opStart = convertToSec(op_start);
        opEnd = convertToSec(op_end);
        cur = convertToSec(pos);
        skipOpening();
        
        for(String str : commands){
            if(str.equals("prev")) prev();
            else next();
            skipOpening();
        }
        
        return convertToString(cur);
    }
    
    public void prev(){
        //뒤로 10초 지나간다..?
        cur = Math.max(cur-10, 0);  // -1초는 0초가 될 것이기 때문...?
    }
    
    public void next(){
        cur = Math.min(cur+10, totalLength);
    }
    
    public void skipOpening(){
        //오프닝이면? 건너뛴다.
        
        //내가 오프닝인가 판별
        if(cur>=opStart && cur<opEnd){
            cur = opEnd;
        }
    }
    
    public int convertToSec(String str){
        st = new StringTokenizer(str,":");
        int min = Integer.parseInt(st.nextToken());
        int sec = Integer.parseInt(st.nextToken());
        
        return min*60 + sec;
    }
    
    public String convertToString(int time){
        //ex) 100초? 1분 40초
        int min = time/60;  //1
        int sec = time%60;  //40
        
        StringBuilder sb = new StringBuilder();
        //min이 한자리 수이다?
        if(min<10) sb.append("0");
        sb.append(min).append(":");
        if(sec<10) sb.append("0");
        sb.append(sec);
        
        return sb.toString();
    }
}
