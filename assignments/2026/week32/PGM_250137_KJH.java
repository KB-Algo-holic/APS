// PGM 250137 - 붕대감기
// 구현
// hhttps://school.programmers.co.kr/learn/courses/30/lessons/250137
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int castTime = bandage[0];        
        int healPerSec = bandage[1];      
        int bonusHeal = bandage[2];       
        
        int maxHealth = health;
        int currentHealth = health;
        int prevTime = 0;
        
        for (int[] attack : attacks) {
            int attackTime = attack[0];
            int damage = attack[1];
             
            int safeTime = attackTime - prevTime - 1;
            
            if (safeTime > 0) { 
                int totalHeal = (safeTime * healPerSec) + ((safeTime / castTime) * bonusHeal);
                currentHealth = Math.min(maxHealth, currentHealth + totalHeal);
            }
             
            currentHealth -= damage;
             
            if (currentHealth <= 0) {
                return -1;
            }
             
            prevTime = attackTime;
        }
        
        return currentHealth;
    }
}
