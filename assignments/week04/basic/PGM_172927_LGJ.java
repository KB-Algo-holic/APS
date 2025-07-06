// PGM 172927 - 광물캐기
// 유형: 그리디/시뮬
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/172927

import java.util.*;
//picks = [1, 1, 0], minerals = ["iron", "iron", "diamond", "iron", "stone", "diamond", "diamond", "diamond"] 5, 15 / 9, 3

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        List<String[]> mineralGroups = new ArrayList<>();

        for (int i=0; i<minerals.length; i += 5) {
            int start = i;
            int end = Math.min(i + 5, minerals.length); // 배열 범위 초과 방지
            String[] mineralGroup = Arrays.copyOfRange(minerals, start, end);
            mineralGroups.add(mineralGroup);
        }
        int totalPickCount = picks[0] + picks[1] + picks[2];
        int groupCount = Math.min(mineralGroups.size(), totalPickCount);
        List<String[]> pickableGroups = mineralGroups.subList(0, groupCount);

        pickableGroups.sort(Comparator.comparingInt(Solution::sumOfMineralGroup).reversed());


        for (String[] mineralGroup : pickableGroups) {
            System.out.println(Arrays.toString(mineralGroup));
            if (picks[0] > 0) {
                for (String mineral : mineralGroup) {
                    answer += getMiningCost(mineral, "diamond");
                }
                picks[0] -= 1;
            } else if (picks[1] > 0) {
                for (String mineral : mineralGroup) {
                    answer += getMiningCost(mineral, "iron");
                }
                picks[1] -= 1;
            } else if (picks[2] > 0) {
                for (String mineral : mineralGroup) {
                    answer += getMiningCost(mineral, "stone");
                }
                picks[2] -= 1;
            } else {
                break;
            }
        }

        return answer;
    }
    // 가장 캐기 힘든 그룹(=stone 곡괭이 기준 피로도 높은 순)부터 정렬
    private static int sumOfMineralGroup(String[] mineralGroup) {
        int sum = 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("diamond", 25);
        map.put("iron", 5);
        map.put("stone", 1);

        for (String mineral : mineralGroup) {
            sum += map.get(mineral);
        }
        return sum;
    }


    // 광물 + 곡괭이 조합에 따른 캐기 비용
    private static int getMiningCost(String mineral, String pick) {
        if (pick.equals("diamond")) {
            return 1;
        } else if (pick.equals("iron")) {
            if (mineral.equals("diamond")) return 5;
            else return 1;
        } else if (pick.equals("stone")) {
            if (mineral.equals("diamond")) return 25;
            else if (mineral.equals("iron")) return 5;
            else return 1;
        }
        return 0;
    }

}