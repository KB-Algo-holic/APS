// PGM - 스티커모으기(2)
// DP
// https://school.programmers.co.kr/learn/courses/30/lessons/12971#

// 황지원 사원 코드 참조 > 너무 어려웠음 추후 꼭 다시 풀어볼 것.
// 결국 두 가지 케이스로 시작됨 0출발 혹은 1출발, 0에서 출발한 경우 마지막 숫자는 고려 대상 제외, 1에서 추가한 경우 마지막 숫자도 고려할 수 있음.
// 위 두 가지 케이스로 점화식을 각각 세우는 것이 key 포인트
// 완전탐색 밖에 가능성이 없다고 생각했지만, 입력값이 length가 100,000인 것을 보고 완탐 불가 하다는 것을 깨닫고 DP 문제일 것 같다고 생각했지만, 점화식을 세우는 데 실패함


import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = -1;
        int n = sticker.length-1;
        // 두 개 이하인 경우 둘 중 큰 값을 자르면 됨
        if (n <= 1) {
            for (int s: sticker) answer = s > answer ? s : answer;
            return answer;
        }

        // 0,1 > 결국 0시작, 1시작
        int[] dp1 = new int[n]; // 0 시작 ~ n-1 (마지막-1) 끝
        int[] dp2 = new int[n]; // 1 시작 ~ n(마지막) 끝

        dp1[0] = sticker[0]; // 0 시작
        dp1[1] = Math.max(sticker[0], sticker[1]); // 0과 1 중 더 큰 값 선택
        for (int i=2; i<n; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2]+sticker[i]); // 비교범위 2 ~ n-1 (마지막 불포함 필수)
        }

        dp2[0] = sticker[1]; // 1 시작
        dp2[1] = Math.max(sticker[1], sticker[2]); // 1과 2 중 더 큰 값 선택 (시작점이 1이기 때문에 비교도 1부터)
        for (int i=2; i<n; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2]+sticker[i+1]); // 비교범위 3 ~ n (마지막 포함 필수)
        }

        //System.out.println("dp1 : " + Arrays.toString(dp1));
        //System.out.println("dp2 : " + Arrays.toString(dp2));

        return Math.max(dp1[n-1], dp2[n-1]);
    }
}