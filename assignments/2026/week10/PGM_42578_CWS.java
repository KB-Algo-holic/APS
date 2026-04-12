// PGM 42578 - 의상
// 해시
// https://school.programmers.co.kr/learn/courses/30/lessons/42578

import java.util.*;

class Solution {

    public int solution(String[][] clothes) {

        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            if(hm.get(clothes[i][1])== null){
                hm.put(clothes[i][1], 1);
            }else{
                hm.put(clothes[i][1], hm.get(clothes[i][1])+1);
            }
        }

        for(int i : hm.values()){
            answer *= (i+1); //옷을 입지 않은경우 +1 을 감안해서 곱해준다
        }

        return --answer; //전부 입지 않은 경우의 수 1을 빼준다
    }


}