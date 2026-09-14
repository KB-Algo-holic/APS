// PGM [PCCP 기출문제] 1번 / 붕대 감기
// https://school.programmers.co.kr/learn/courses/30/lessons/250137
// 구현

class Solution {
    int curHealth;
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        
        // 몬스터의 공격을 걍 for문 돌것임.
        int curTime = 0; // 현재 시간
        curHealth = health;
        
        int t = 0;
        int damage = 0;
        int healTime =0;
        int mod = 0;
        
        for(int[] attack : attacks){
            // System.out.println("지금 시간은?! "+curTime);
            t = attack[0];
            damage = attack[1];
            
            // 일단 내가 지금 t까지 버틴 시간만큼 체력 회복할거임!
            healTime = t - curTime-1;
            if(healTime > 0){
                curHealth+=(healTime*bandage[1]);

                // 지금 버틴 시간이 보너스 타임을 가질 수 있는가?
                mod = healTime / bandage[0];
                if(mod > 0){
                    curHealth += mod * bandage[2];
                }

                curHealth = Math.min(curHealth, health);
            }
            
            // 이제 공격당할거임
            curHealth -= damage;
            curTime = t;
            if(curHealth<0) break;
            
        }
        
        
        
        return curHealth>0?curHealth : -1;
    }
}
