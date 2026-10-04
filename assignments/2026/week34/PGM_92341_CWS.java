// PGM 92341 - 주차요금계산
// 시뮬레이션
// https://school.programmers.co.kr/learn/courses/30/lessons/92341

import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {

        HashMap<String, Integer> carTotalTime = new HashMap<>();
        HashMap<String, String> carInTime = new HashMap<>();
        HashSet<String> hs = new HashSet<>();

        for(String s : records){
            StringTokenizer st = new StringTokenizer(s);
            String time = st.nextToken();
            String num = st.nextToken();
            String inOut = st.nextToken();


            hs.add(num);
            if(inOut.equals("IN")) {
                carInTime.put(num, time);
            }else{
                String startTime = carInTime.get(num);
                String endTime = time;
                int start = Integer.parseInt(startTime.substring(0,2)) * 60 + Integer.parseInt(startTime.substring(3,5));
                int end = Integer.parseInt(endTime.substring(0,2)) * 60 + Integer.parseInt(endTime.substring(3,5));
                int t = end - start;
                if(carTotalTime.get(num) == null){
                    carTotalTime.put(num, t);
                }else{
                    t += Integer.parseInt(carTotalTime.get(num).toString());
                    carTotalTime.put(num, t);
                }
                carInTime.put(num, "23:59");

            }
        }
        for(String s : hs){
            String startTime = carInTime.get(s);
            String endTime = "23:59";
            int start = Integer.parseInt(startTime.substring(0,2)) * 60 + Integer.parseInt(startTime.substring(3,5));
            int end = Integer.parseInt(endTime.substring(0,2)) * 60 + Integer.parseInt(endTime.substring(3,5));
            int t = end-start;
            if(carTotalTime.get(s) != null)
                t+= carTotalTime.get(s);
            carTotalTime.put(s, t);

        }
        int[] answer = new int[hs.size()];
        int cnt = 0;
        for(int i = 0; i < 10000; i++){
            if(carTotalTime.get(String.format("%04d", i)) != null){
                int fee = carTotalTime.get(String.format("%04d", i));
                fee -= fees[0];
                int answerNum = fees[1];
                if(fee > 0){
                    if(fee%fees[2] == 0) answerNum += fee/fees[2] * fees[3];
                    else answerNum += (fee/fees[2] + 1) * fees[3];
                }
                answer[cnt++] = answerNum;
            }
        }

        return answer;
    }
}