// PGM - 1845 포켓몬
// 해쉬
// https://school.programmers.co.kr/learn/courses/30/lessons/1845

import java.util.HashMap;
class Solution {

    public int solution(int[] types) {

        HashMap<Integer, Integer> typeCntMap = new HashMap<Integer, Integer>();
        for (int type: types) {
            typeCntMap.put(type, typeCntMap.getOrDefault(type, 0)+1);
        }

        return Math.min(typeCntMap.keySet().size(), types.length / 2);

    }

}