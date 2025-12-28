// PGM - 주사위 고르기
// 완전탐색 + 이분탐색
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

    // 주사위 승률 계산
    void calculate(List<Integer> diceNums1, List<Integer> diceNums2, int[][] dices, int n, int r) {
        List<Integer> sumList1 = new ArrayList<>();
        List<Integer> sumList2 = new ArrayList<>();
        dfs(0, 0, diceNums1, dices, sumList1);
        dfs(0, 0, diceNums2, dices, sumList2);

        Collections.sort(sumList2);

        // 이분탐색
        int cnt1 = 0, cnt2 = 0;
        for (int s1 : sumList1) {
            // sumList2에서 s1보다 작은 원소 개수
            int win = lowerBound(sumList2, s1);
            cnt1 += win;

            // sumList2에서 s1보다 큰 원소 개수
            int lose = sumList2.size() - upperBound(sumList2, s1);
            cnt2 += lose;
        }

        if (cnt1 > cnt2 && cnt1 > maxCnt) {
            maxCnt = cnt1;
            for (int i=0; i<r; i++) answer[i] = diceNums1.get(i)+1;
        } else if (cnt2 > cnt1 && cnt2 > maxCnt) {
            maxCnt = cnt2;
            for (int i=0; i<r; i++) answer[i] = diceNums2.get(i)+1;
        }
    }

    // lowerBound: 처음으로 target 이상이 되는 위치
    int lowerBound(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    // upperBound: 처음으로 target 초과가 되는 위치
    int upperBound(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) <= target) left = mid + 1;
            else right = mid;
        }
        return left;
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

}