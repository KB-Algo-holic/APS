package week35;

import java.util.Arrays;
public class PGM_43236_HSH {

    public static void main(String args[]) {
        int dis = 25;
        int[] rocks = {
            2, 14, 11 ,21, 17
        };
        int n = 2;

        int answer = solution(dis, rocks, n);
        System.out.println(answer);
    }
    public static int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int left = 1;
        int right = distance;
        int answer = 0;

        while (left <= right) {
            // 확보하려는 최소 간격
            int mid = left + (right - left) / 2;

            int removed = 0;
            int prev = 0; // 마지막으로 남긴 지점: 처음에는 출발점

            for (int rock : rocks) {
                if (rock - prev < mid) {
                    // 간격이 부족하면 현재 바위를 제거
                    // prev는 마지막으로 남긴 지점이므로 변경하지 않음
                    removed++;
                } else {
                    // 간격이 충분하면 현재 바위를 남김
                    prev = rock;
                }
            }

            // 마지막으로 남긴 바위와 도착점 사이의 간격 확인
            if (distance - prev < mid) {
                // 도착점은 제거할 수 없으므로 마지막 바위를 추가 제거
                removed++;
            }

            if (removed <= n) {
                // 현재 최소 간격을 확보할 수 있으므로 더 큰 간격 탐색
                answer = mid;
                left = mid + 1;
            } else {
                // 제거해야 할 바위가 너무 많으므로 더 작은 간격 탐색
                right = mid - 1;
            }
        }

        return answer;
    }
}
