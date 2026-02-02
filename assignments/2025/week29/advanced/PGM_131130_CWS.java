// PGM 131130 - 혼자 놀기의 달인
// 유형: 완전탐색
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/131130

import java.util.*;

class Solution {
    public int solution(int[] cards) {

        // 방문 여부 체크
        boolean[] checked = new boolean[cards.length];

        // 가장 큰 두 그룹
        int n1 = 0;
        int n2 = 0;

        while(true){
            int num = -1;
            int cnt = 0;

            // 방문하지 않은 카드 찾기
            for(int i = 0; i < cards.length; i++){
                if(!checked[i]){
                    checked[i] = true;
                    cnt++;
                    num = i;
                    break;
                }
            }

            if(num == -1) break;

            // 다음으로 이동
            while(!checked[cards[num] - 1]){
                cnt++;
                num = cards[num] - 1;
                checked[num] = true;
            }

            // 크기 갱신
            if(cnt >= n1){
                n2 = n1;
                n1 = cnt;
            }else if(cnt > n2){
                n2 = cnt;
            }
        }
        return n1 * n2;
    }
}
