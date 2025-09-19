// PGM 258709 - 주사위 고르기
// 순열, 이진탐색
// https://school.programmers.co.kr/learn/courses/30/lessons/258709

import java.util.*;

class Solution {

    // A가 먼저 고른다. (1부터 n까지)
    // B는 자동으로 나머지를 선택한다.
    // B의 합 리스트를 정렬한 다음
    // A 합 값을 B 합 안에서 이진탐색(엄격히 작은 개수)하여 승수 계산
    // 승수가 최대가 되는 A 조합을 기록
    // permutation 형식: "1 3 5 7 9/2 4 6 8 10"

    List<String> permutation = new ArrayList<>();
    int[] permArr;                 // 선택 여부 표시
    String maxWinRateArr = "";     // 최종 A 조합 (공백 구분 문자열)
    long maxWinCount = -1;         // 승수 최대값 (비교용)

    // 공백 구분으로 A를 만들고, 나머지(B)도 공백 구분으로 만들어 저장
    void setPermList(String perm, int n, int times, int idx) {
        int half = n / 2;
        if (times == half) {
            // get B perm (공백 구분)
            StringBuilder remain = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if (permArr[i - 1] == 0) {
                    if (remain.length() > 0) remain.append(" ");
                    remain.append(i);
                }
            }
            // A 조합도 공백으로 구분해서 저장
            permutation.add(perm.trim() + "/" + remain);
            return;
        }

        for (int i = idx; i <= n; i++) {
            if (permArr[i - 1] == 0) {
                permArr[i - 1] = 1;
                // A 조합을 "1 3 5 "처럼 공백 포함해 누적
                setPermList(perm + i + " ", n, times + 1, i + 1);
                permArr[i - 1] = 0;
            }
        }
    }

    // 공백으로 split된 주사위 번호를 순서대로 사용해 합 리스트 생성
    List<Integer> getSumList(int[][] dice, String dices, int sum, int idx, List<Integer> sumList){
        String[] arr = dices.split(" ");
        if (idx == arr.length) {
            sumList.add(sum);
            return sumList;
        }
        int di = Integer.parseInt(arr[idx]) - 1; // 1-based → 0-based
        for (int f = 0; f < 6; f++) {
            getSumList(dice, dices, sum + dice[di][f], idx + 1, sumList);
        }
        return sumList;
    }

    // B 합 리스트에서 target보다 작은 값의 개수 (lower_bound)
    int countLessThan(List<Integer> sortedList, int target) {
        int left = 0, right = sortedList.size(); // [left, right)
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sortedList.get(mid) >= target) right = mid;
            else left = mid + 1;
        }
        return left; // 첫 번째 >= target 위치 == target 미만 개수
    }

    void match(int[][] dice, String A, String B){
        List<Integer> sumListA = getSumList(dice, A, 0, 0, new ArrayList<>());
        List<Integer> sumListB = getSumList(dice, B, 0, 0, new ArrayList<>());

        // B 합 정렬 (이진탐색 준비)
        Collections.sort(sumListB);

        long winCount = 0L;
        for (int a : sumListA) {
            // B < A 인 개수 누적
            winCount += countLessThan(sumListB, a);
        }

        // 승수 최대 갱신 시 기록 (동률이면 사전순 앞선 A 유지)
        if (winCount > maxWinCount) {
            maxWinCount = winCount;
            maxWinRateArr = A;
        } else if (winCount == maxWinCount) {
            if (A.compareTo(maxWinRateArr) < 0) maxWinRateArr = A;
        }
    }

    public int[] solution(int[][] dice) {
        int n = dice.length;
        int half = n / 2;
        int[] answer = new int[half];

        permArr = new int[n];
        setPermList("", n, 0, 1);

        for (String p : permutation) {
            String[] ab = p.split("/");
            String A = ab[0];
            String B = ab[1];
            match(dice, A, B);
        }

        // 최종 A 조합을 공백 분리하여 숫자 배열로 변환
        String[] pickedA = maxWinRateArr.split(" ");
        for (int i = 0; i < half; i++) {
            answer[i] = Integer.parseInt(pickedA[i]);
        }
        return answer;
    }
}