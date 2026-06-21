// PGM 131127 - 할인 행사
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/131127?language=java

import java.util.HashMap;

public class PGM_131127_PST {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        HashMap<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            HashMap<String, Integer> discountMap = new HashMap<>();

            for (int j = i; j < i + 10; j++) {
                discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
            }

            if (wantMap.equals(discountMap)) {
                answer++;
            }
        }

        return answer;
    }
}
