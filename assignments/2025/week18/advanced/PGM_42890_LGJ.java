// PGM - 후보키
// 구현 - 조합
// https://school.programmers.co.kr/learn/courses/30/lessons/42890

import java.util.*;

class Solution {
    int rowCnt, colCnt;
    List<List<String>> cols = new ArrayList<>(); // 컬럼 리스트 (row 순서별)
    List<Set<Integer>> candidateKeys = new ArrayList<>(); // 후보키 개수

    public int solution(String[][] relation) {
        rowCnt = relation.length;
        colCnt = relation[0].length;

        // 컬럼 단위 저장
        for (int c = 0; c < colCnt; c++) {
            List<String> col = new ArrayList<>();
            for (int r = 0; r < rowCnt; r++) {
                col.add(relation[r][c]);
            }
            cols.add(col);
        }

        // 1~colCnt개의 컬럼 조합 생성
        for (int i = 1; i <= colCnt; i++) {
            comb(0, i, new int[i], 0);
        }
        return candidateKeys.size();
    }

    void comb(int start, int r, int[] cur, int depth) {
        if (depth == r) {
            if (isUnique(cur) && isMinimal(cur)) {
                // 후보키 등록
                Set<Integer> key = new HashSet<>();
                for (int c : cur) key.add(c);
                candidateKeys.add(key);
            }
            return;
        }
        for (int i = start; i < colCnt; i++) {
            cur[depth] = i;
            comb(i + 1, r, cur, depth + 1);
        }
    }

    boolean isUnique(int[] comb) {
        Set<String> set = new HashSet<>();
        for (int r = 0; r < rowCnt; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c : comb) sb.append(cols.get(c).get(r)).append(",");
            set.add(sb.toString());
        }
        return set.size() == rowCnt;
    }

    boolean isMinimal(int[] comb) {
        Set<Integer> curSet = new HashSet<>();
        for (int c : comb) curSet.add(c);
        for (Set<Integer> key : candidateKeys) {
            if (curSet.containsAll(key)) return false; // 기존 키의 부분집합이면 탈락
        }
        return true;
    }
}
