// PGM 131701 - 연속 부분 수열 합의 개수
// 연속합
// https://school.programmers.co.kr/learn/courses/30/lessons/131701

import java.util.*;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> hs = new HashSet<>();
        int[] arr = new int[elements.length*2];
        for(int i = 0; i < arr.length; i++){
            arr[i] = elements[i % elements.length];
        }
        for(int i = 0; i < elements.length; i++){
            int n = 0;
            for(int j = i; j < elements.length+i; j++){
                n+=arr[j];
                hs.add(n);
            }
        }
        return hs.size();
    }
}