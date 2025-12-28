// PGM - 주사위 고르기
// 완전탐색 + 해쉬
// https://school.programmers.co.kr/learn/courses/30/lessons/258709


import java.util.*;
class Solution {
    // 주사위 set a, b가 있는 경우, a가 이기는 경우의 수, b가 이기는 경우의 수를 구할 수 있음
    Set<List<Integer>> set = new HashSet();
    int[] answer;
    int maxCnt = 0;

    public int[] solution(int[][] dices) {

        int n = dices.length; // 최대 n = 10
        int r = n / 2; // 최대 r = 5
        answer = new int[r];
        comb(n, r, new int[r], 0, 0, dices);

        return answer;//각 원소 +1
    }

    void comb(int n, int r, int[] cur, int depth, int idx, int[][]dices) {

        if (depth == r) {
            // 중복 제거를 위해 set에 담아서 검사 (검사를 위해 List로 전환)
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for (int a: cur) list1.add(a);
            if (set.contains(list1)) return;
            for (int i=0; i<n; i++) if (!list1.contains(i)) list2.add(i);
            set.add(list1);
            set.add(list2);

            calculate(list1, list2, dices, n, r);
            return;
        }

        for (int i=idx; i<n; i++) {
            cur[depth] = i;
            comb(n, r, cur, depth+1, i+1, dices);
        }
    }

    void calculate(List<Integer> diceNums1, List<Integer> diceNums2, int[][] dices, int n, int r) {

        int total = (int) Math.pow(6, r); // r개의 주사위가 가질 수 있는 전체 경우의 수
        List<Integer> sumList1 = new ArrayList<>();
        List<Integer> sumList2 = new ArrayList<>();
        // 각각 모든 경우의 합 구하기
        dfs(0, 0, diceNums1, dices, sumList1);
        dfs(0, 0, diceNums2, dices, sumList2);

        // 중복 제거를 위해 map에 담기
        Map<Integer, Integer> freq1 = buildFreq(sumList1);
        Map<Integer, Integer> freq2 = buildFreq(sumList2);

        // 승패 세기
        // map에 담아서 유니크한 값들만 검사 > 각 값의 개수를 통해
        int cnt1 = 0, cnt2 = 0;
        for (Map.Entry<Integer, Integer> e1 : freq1.entrySet()) {
            int sum1 = e1.getKey();
            int count1 = e1.getValue();
            for (Map.Entry<Integer, Integer> e2 : freq2.entrySet()) {
                int sum2 = e2.getKey();
                int count2 = e2.getValue();
                if (sum1 > sum2) cnt1 += count1 * count2;
                else if (sum2 > sum1) cnt2 += count1 * count2;
            }
        }

        // max 검사
        if (cnt1 > cnt2 && cnt1 > maxCnt) {
            maxCnt = cnt1;
            for (int i=0; i<r; i++) answer[i] = diceNums1.get(i)+1;
        } else if (cnt2 > cnt1 && cnt2 > maxCnt) {
            maxCnt = cnt2;
            for (int i=0; i<r; i++) answer[i] = diceNums2.get(i)+1;
        }
    }

    // 각 주사위 별 합 구하기
    void dfs(int depth, int sum, List<Integer> diceNums, int[][] dices, List<Integer> sumList) {
        if (depth == diceNums.size()) {
            sumList.add(sum);
            return;
        }
        int diceIdx = diceNums.get(depth);
        for (int face : dices[diceIdx]) {
            dfs(depth + 1, sum + face, diceNums, dices, sumList);
        }
    }

    // sumList > map (중복제거)
    Map<Integer, Integer> buildFreq(List<Integer> sums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int s : sums) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }
        return freq;
    }
}