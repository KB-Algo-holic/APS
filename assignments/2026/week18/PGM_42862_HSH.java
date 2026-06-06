package week18;

import java.util.Arrays;

public class PGM_42862_HSH {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int answer = n - lost.length; // 전체에서 잃어버린 수 빼는게 최소 수업 가능
        // 잃어버린 놈들
        for (int i = 0; i < lost.length; i++) {
            // 여분 가진 놈들 비교
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    // 동일하다면 결국 여분 가진놈이 잃어버린거라 참석 가능
                    answer++;
                    lost[i] = -1; // 처리할 수 없는 값으로 셋팅
                    reserve[j] = -1; // 처리할 수 없는 값으로 셋팅
                }
            }
        }

        // 이번엔 빌려주는 경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if ((lost[i] == reserve[j] - 1) || (lost[i] == reserve[j] + 1)) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                }
            }
        }

        // 앞뒤로해서 빌려주고 명단에서 뺄 것

        return answer;
    }
} 