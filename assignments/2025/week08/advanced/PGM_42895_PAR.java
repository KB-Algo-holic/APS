# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 42895 - N으로 표현
# 유형: 해시
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42895

import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        Set<Integer>[] sets = new HashSet[9];       
        sets[1] = new HashSet<>();
        sets[1].add(N);
        
        if(sets[1].contains(number))
            answer = 1;
        else {
            for(int i = 2; i < sets.length; i++) {
                sets[i] = new HashSet<>();
                
                for(int j = 1; j <= Math.round(i / 2.0); j++)
                    sets[i].addAll(calc(N, i, sets[j], sets[i - j]));
                
                if(sets[i].contains(number)) {
                    answer = i;
                    break;
                }
            }
        }
        
        return answer;
    }
    
    private Set<Integer> calc(int N, int idx, Set<Integer> A, Set<Integer> B) {
        Set<Integer> set = new HashSet<>();
        
        int num = 0;
        for(int i = 0; i < idx; i++)
            num += Math.pow(10, i) * N;
        set.add(num);
        
        A.forEach(a -> {
            B.forEach(b -> {
                set.add(a + b);
                set.add(a * b);
                set.add(a - b);
                set.add(b - a);
                
                if(b != 0)
                    set.add(a / b);
                if(a != 0)
                    set.add(b / a);
            });
        });
        
        return set;
    }
}