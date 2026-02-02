// PGM 250137 - 붕대 감기
// 시뮬레이션
// https://school.programmers.co.kr/learn/courses/30/lessons/250137

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHp = health;

        for(int i = 0; i < attacks.length; i++){
            if(i != 0){
                int cooltime = attacks[i][0] - attacks[i-1][0] - 1; // 몇 초간 붕대감기를 시전할 수 있는지
                int plus = 0;
                if(cooltime >= bandage[0]){
                    plus = (cooltime / bandage[0]) * bandage[0] * bandage[1] + (cooltime / bandage[0])  * bandage[2];
                }
                plus += (cooltime % bandage[0]) * bandage[1];
                health += plus;
                if(maxHp < health){
                    health = maxHp;
                }
            }

            health -= attacks[i][1];
            if(health <= 0) {
                return -1;
            }
        }
        return health;
    }
}