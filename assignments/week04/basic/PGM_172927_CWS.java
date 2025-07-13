// PGM 172927 - 광물캐기
// 유형: 그리디
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/172927

import java.util.*;

class Solution {

    static int answer = 0;

    public int solution(int[] picks, String[] minerals) {

        int[] greedNum = {1000,1000,1000,1000,1000,1000,1000,1000,1000,1000};
        System.out.print(Arrays.toString(greedNum));

        int leng = minerals.length;단
            leng = (picks[0] + picks[1] + picks[2]) * 5;
        }

        // 자릿수로 돌 판
        // ex) 212 -> 다이아몬드2, 철1, 돌2
        for(int i = 0; i < leng; i++){
            if(minerals[i].equals("diamond")){
                greedNum[i/5] += 100;
            }else if(minerals[i].equals("iron")){
                greedNum[i/5] += 10;
            }else if(minerals[i].equals("stone")){
                greedNum[i/5] += 1;
            }
        }
        Arrays.sort(greedNum);

        for(int i = 9; i >= 0; i--){
            if(greedNum[i] == 1000){
                i = 0;
            }else{
                if(picks[0] > 0){
                    picks[0] -= 1;
                    answer += (greedNum[i]+"").charAt(1) - '0';
                    answer += (greedNum[i]+"").charAt(2) - '0';
                    answer += (greedNum[i]+"").charAt(3) - '0';
                }else if(picks[1] > 0){
                    picks[1] -= 1;
                    answer += ((greedNum[i]+"").charAt(1) - '0') * 5;
                    answer += (greedNum[i]+"").charAt(2) - '0';
                    answer += (greedNum[i]+"").charAt(3) - '0';
                }else if(picks[2] > 0){
                    picks[2] -= 1;
                    answer += ((greedNum[i]+"").charAt(1) - '0') * 25;
                    answer += ((greedNum[i]+"").charAt(2) - '0') * 5;
                    answer += (greedNum[i]+"").charAt(3) - '0';
                }
            }
        }
        return answer;
    }

}