// PGM 67258 - 보석 쇼핑
// 유형: 투포인터
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/67258

import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {1,1}; // 기본값

        // 1. 전체 종류
        HashSet<String> hs = new HashSet<>();
        for(String gem : gems){
            hs.add(gem);
        }

        int l = 0; // 왼쪽
        int r = 0; // 오른쪽
        int min = Integer.MAX_VALUE;

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put(gems[0], 1);

        // 1인경우 바로 반환
        if(hs.size() != 1){
            // 오른쪽 포인터가 끝까지 갈 때까지 반복
            while(r != gems.length - 1){
                r += 1; // 오른쪽 확장

                // 새로운 보석이면 추가, 있으면 개수 증가
                hm.put(gems[r], hm.getOrDefault(gems[r], 0) + 1);

                // 현재 구간에 모든 보석이 들어있다면 최소 구간 확인
                if(hm.size() == hs.size()){
                    while(true){
                        // 왼쪽 보석 개수가 2 이상이면 줄이기 (불필요한 중복 제거)
                        if(hm.get(gems[l]) > 1){
                            hm.put(gems[l], hm.get(gems[l]) - 1);
                            l += 1;
                        }else{
                            // 구간 길이 갱신 조건 확인
                            hm.clear();
                            if(r - l < min){
                                answer[0] = l + 1; // 시작 인덱스(1-based)
                                answer[1] = r + 1; // 끝 인덱스(1-based)
                                min = r - l;
                            }
                            break;
                        }
                    }
                    // 다음 탐색을 위해 포인터 재조정
                    l += 1;
                    r = l;
                    hm.put(gems[r], 1);
                }
            }
        }

        return answer;
    }
}
