// PGM - 보석쇼핑
// 투포인터
// https://school.programmers.co.kr/learn/courses/30/lessons/67258


import java.util.*;


class Solution {
    public int[] solution(String[] gems) {
        // answer init
        int[] answer = {1, gems.length};
        int minCnt = gems.length;

        // type init
        Set<String> types = new HashSet<>();
        int typeCnt = 0;
        for (String gem: gems) types.add(gem);
        typeCnt = types.size();

        // two point init
        int left = 0, right = 0;
        Map<String, Integer> shopList = new HashMap<>();

        while (right < gems.length) {
            // 모든 타입을 담기 위해 right 확장
            String rightGem = gems[right];
            shopList.put(rightGem, shopList.getOrDefault(rightGem, 0) + 1);
            right ++;

            // 모든 타입을 담은 경우
            while (shopList.size() == typeCnt) {

                // set Answer
                if ((right-left) < minCnt) {
                    minCnt = right-left;
                    answer[0] = left+1;
                    answer[1] = right;
                }

                // Left 최소화
                String leftGem = gems[left];
                shopList.put(leftGem, shopList.get(leftGem) - 1);
                if (shopList.get(leftGem) == 0) {
                    shopList.remove(leftGem);
                }
                left++;
            }
        }

        return answer;
    }
}