

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // vars init
        int[] answer = new int[N];
        int[] arrive = new int[N+1];
        int[] fail = new int[N+1];

        // 도달 및 실패 배열 저장
        for (int curStage : stages) {
            for (int i=1; i<=curStage; i++) {
                if (i==N+1) continue;
                arrive[i]++;
                if (i==curStage) fail[i]++;
            }
        }

        //System.out.println(Arrays.toString(arrive));
        //System.out.println(Arrays.toString(fail));

        // 실패율 맵 init
        Map<Integer, Double> map = new HashMap<>();

        // 실패율 계산
        for (int s=1; s<=N; s++) {
            double rate;
            if (arrive[s] == 0) {
                rate = 0.0;
            } else {
                rate = (double) fail[s] / arrive[s];
            }
            map.put(s, rate);
        }
        //System.out.println(map);

        // 실패율 맵 정렬 (내림차순)
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((a, b) -> map.get(b).compareTo(map.get(a)));
        //System.out.println(keySet);

        for (int i=0; i<N; i++) {
            answer[i] = keySet.get(i);
        }
        return answer;
    }
}