class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {

        int t = 1;
        int cnt = 0;
        int aI = 0;
        int answer = health;

        while (t <= attacks[attacks.length - 1][0]) {

            if (attacks[aI][0] == t) {
                answer -= attacks[aI][1];
                aI++;
                cnt = 0;
                if (answer <= 0) break;
            } else {
                answer += bandage[1];
                cnt++;
                if (cnt == bandage[0]) {
                    answer += bandage[2];
                    cnt = 0;
                }
                if (answer > health) answer = health;
            }

            t++;
        }

        return answer <= 0 ? -1 : answer;
    }
}