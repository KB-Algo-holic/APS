// PGM 340213 - 동영상 재생기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/340213

import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int posNum = Integer.parseInt(pos.substring(0,2)) * 60
                + Integer.parseInt(pos.substring(3,5));
        int startNum = Integer.parseInt(op_start.substring(0,2)) * 60
                + Integer.parseInt(op_start.substring(3,5));
        int endNum = Integer.parseInt(op_end.substring(0,2)) * 60
                + Integer.parseInt(op_end.substring(3,5));
        int videoNum = Integer.parseInt(video_len.substring(0,2)) * 60
                + Integer.parseInt(video_len.substring(3,5));

        if(posNum >= startNum && posNum <= endNum){
            pos = op_end;
            posNum = Integer.parseInt(pos.substring(0,2)) * 60
                    + Integer.parseInt(pos.substring(3,5));
        }

        for(int i = 0; i < commands.length; i++){
            if(commands[i].equals("prev")){
                if(posNum < 10){
                    posNum = 0;
                }else{
                    posNum -= 10;
                }
            }else{
                if((posNum + 10) > videoNum){
                    posNum = videoNum;
                }else{
                    posNum += 10;
                }
            }

            if(posNum >= startNum && posNum <= endNum){
                pos = op_end;
                posNum = Integer.parseInt(pos.substring(0,2)) * 60
                        + Integer.parseInt(pos.substring(3,5));
            }
        }



        StringBuilder sb = new StringBuilder();

        if((posNum/60) < 10){
            sb.append("0");
            sb.append(posNum/60);
        }else{
            sb.append(posNum/60);
        }

        sb.append(":");

        if((posNum%60) < 10){
            sb.append("0");
            sb.append(posNum%60);
        }else{
            sb.append(posNum%60);
        }


        String answer = sb.toString();
        return answer;
    }
}