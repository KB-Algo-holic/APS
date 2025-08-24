// PGM 250137 - 붕대 감기
// 유형: 시뮬레이션
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/250137

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxTime = attacks[attacks.length-1][0];
        int maxHealth = health;
        int attacksCnt = 0;
        int bandageTime = 1;

        for(int i = 1; i <= maxTime; i++){

            //공격 받는경우
            if(attacks[attacksCnt][0] == i){
                health -= attacks[attacksCnt++][1];
                bandageTime = 1;
                if(health <= 0){
                    health = -1;
                    break;
                }
            }else{//붕대 감는경우
                if(bandageTime >= bandage[0]){//추가 회복
                    health += bandage[1] + bandage[2];
                    bandageTime = 1;
                }else{//기본 회복
                    health += bandage[1];
                    bandageTime++;
                }
            }
            //최대체력 제한
            if(health > maxHealth){
                health = maxHealth;
            }
        }

        return health;
    }
}