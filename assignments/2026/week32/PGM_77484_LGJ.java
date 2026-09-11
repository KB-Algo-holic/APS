// PGM 77484 로또의 최고순위와 최저 순위
// 해시, 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/77484


import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        // 결국 0이 다 맞는 케이스와 하나도 안맞는 케이스

        Map<Integer, Integer> map = new HashMap<>();
        map.put(6, 1);
        map.put(5, 2);
        map.put(4, 3);
        map.put(3, 4);
        map.put(2, 5);
        map.put(1, 6);
        map.put(0, 6);

        Set<Integer> set = new HashSet<>();

        for (int num: win_nums) {
            set.add(num);
        }
        int correct = 0;
        int zero = 0;
        for (int num: lottos) {
            if (set.contains(num)) correct ++;
            else if (num == 0) zero ++;
        }

        answer[0] = map.get(correct+zero);
        answer[1] = map.get(correct);



        return answer;
    }
}