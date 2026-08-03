import java.util.Arrays;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/42884?language=java
 * 요구사항 : 고속도로를 이동하는 모든 차량이 한번은 단속용 카메라를 만나도록 하려면 최소 몇 대의 카메라를 설치해야하는지 구해라
 * 입력 : 고속도로를 이동하는 차량의 경로 routes
 * 출력 : 최소로 설치해야하는 카메라 대수
 * 제약
 * - 1 <= 차량의 대수 <= 10000
 * - routes[i][0] : i번째 차량이 고속도로에 진입한 지점
 * - routes[i][1] : i번째 차량이 고속도로에서 나간 지점
 * - -30000 <= 차량의 진입 지점, 진출 지점 <= 30000
 *
 * 풀이 과정
 * - [i][1] 기준 오름차순 정렬
 * - i for문 : [i][1] 보다 큰 [i][1]이 나올때까지
 *      - 작거나 같으면 i는 ++
 *      - 크면 카메라 개수 하나 늘리고 그 [i][1] 부터 다음 i로 비교
 */

import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        answer++;
        int cameraPos = routes[0][1];
        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] > cameraPos) {
                cameraPos = routes[i][1];
                answer++;
            }
        }

        return answer;
    }
}
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        answer++;
        int cameraPos = routes[0][1];
        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] > cameraPos) {
                cameraPos = routes[i][1];
                answer++;
            }
        }

        return answer;
    }
}
