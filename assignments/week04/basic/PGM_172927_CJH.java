// PGM 172927 - 광물 캐기
// 유형 : 그리디, 시뮬레이션
// 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/172927

import java.util.Arrays;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int idx = (int) Math.ceil((double) minerals.length / 5);
        int[][] count = new int[idx][3];
        int picksum = 0;
        for (int i : picks)
            picksum += i * 5;
        int countsum = picksum;

        for (int i = 0; i < idx; i++) {
            for (int j = i * 5; j < Math.min((i + 1) * 5, minerals.length); j++) {
                switch (minerals[j]) {
                case "diamond":
                    count[i][0]++;
                    break;
                case "iron":
                    count[i][1]++;
                    break;
                case "stone":
                    count[i][2]++;
                    break;
                }
            }
            countsum -= 5;
            if (countsum == 0) {
                countsum = -1;
                Arrays.sort(count, (o1, o2) -> {
                    if (o1[0] == o2[0]) {
                        return Integer.compare(o2[1], o1[1]);
                    } else {
                        return Integer.compare(o2[0], o1[0]);
                    }
                });
            }
        }

        if (picksum >= minerals.length) {
            Arrays.sort(count, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o2[1], o1[1]);
                } else {
                    return Integer.compare(o2[0], o1[0]);
                }
            });
        }

        int dia = picks[0];
        int iron = picks[1];
        int stone = picks[2];
        for (int i = 0; i < idx; i++) {
            if (dia > 0) {
                answer += count[i][0] + count[i][1] + count[i][2];
                dia--;
            } else if (iron > 0) {
                answer += count[i][0] * 5 + count[i][1] + count[i][2];
                iron--;
            } else {
                answer += count[i][0] * 25 + count[i][1] * 5 + count[i][2];
                stone--;
            }
            picksum -= 5;
            if (picksum == 0) {
                return answer;
            }
        }

        return answer;
    }
}