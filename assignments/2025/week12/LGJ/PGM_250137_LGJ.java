// PGM 붕대감기
// 시뮬레이션
//https://school.programmers.co.kr/learn/courses/30/lessons/250137

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = -1;
        int length = attacks.length;
        int max_health = health;
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];

        for (int i=0; i<length; i++) {
            // 현재 공격
            health -= attacks[i][1];
            // 사망
            if (health <= 0) break;
            // 다음 공격 존재 시
            if (i < length-1) {
                int cur_time = attacks[i][0];
                int next_time = attacks[i+1][0];
                int period = next_time - cur_time -1; //실제 회복 가능한 시간
                int recovery = 0;

                if (period >= t)  recovery = (period / t) * y + (period * x);
                else recovery += (period * x);
                health += recovery;

                // 회복량 초기화
                if (health > max_health) health = max_health;
            }

        }

        return health>0 ? health : -1;
    }
}