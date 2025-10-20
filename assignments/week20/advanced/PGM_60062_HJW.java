// PGM 60062 - 외벽 점검
// 유형: 그리디, 해쉬
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/60062

package assignments.week20.advanced;

import java.util.*;

class PGM_60062_HJW {
    public int solution(int n, int[] weak, int[] dist) {
        
        int len = weak.length;
        HashSet<Integer> points = new HashSet<>();
        for (int w : weak) points.add(w);
        
        Arrays.sort(dist);
        int[] dists = new int[dist.length];
        for (int i=0; i<dists.length; i++) dists[i] = dist[dists.length-1-i];
        
        HashSet<HashSet<Integer>> repaired = new HashSet<>();
        repaired.add(new HashSet<>());
        
        for (int i=0; i<dists.length; i++) {
            int man = dists[i];
            ArrayList<HashSet<Integer>> repairs = new ArrayList<>();
            for (int w : weak) {
                HashSet<Integer> set = new HashSet<>();
                for (int j=w; j<=w+man; j++) {
                    int idx = j%n;
                    if (points.contains(idx)) set.add(idx);
                }
                repairs.add(set);
            }
            HashSet<HashSet<Integer>> newRepaired = new HashSet<>();
            for (HashSet<Integer> a : repairs) {
                for (HashSet<Integer> b : repaired) {
                    HashSet<Integer> newSet = new HashSet<>(a);
                    newSet.addAll(b);
                    if (newSet.size() == len) return i+1;
                    newRepaired.add(newSet);
                }
            }
            repaired = newRepaired;
        }
        return -1;
    }
}