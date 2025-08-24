import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int continueCnt = 0; //연속성공
        int nowHealth = health; //현재체력
        int maxCount = attacks[attacks.length-1][0]; //최대공격넘버
        
        for(int idx = 0; idx <=maxCount; idx++) {
            boolean bAttack = false;
            
            for(int[] temp : attacks){
                if(temp[0] == idx) {
                    bAttack = true;
                    nowHealth = nowHealth - temp[1];
                    
                    if(nowHealth <= 0) {
                        return -1;
                    }
                    continueCnt = 0;
                    break;
                }
            }
            
            if(bAttack == false) {
                if(idx == 0) {
                    continueCnt = 0;
                } else {
                    continueCnt += 1;
                }
                nowHealth = nowHealth + bandage[1]; //일반공격성공
                
                if(continueCnt == bandage[0]) {
                    continueCnt = 0;
                    nowHealth = nowHealth + bandage[2]; //연속공격성공
                }
                
                if(nowHealth >= health) {
                    nowHealth = health;
                }
            }
        }
        answer = nowHealth >0 ? nowHealth : -1;
        
        return answer;
    }
}