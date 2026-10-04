// PGM 1845 폰켓몬
// https://school.programmers.co.kr/learn/courses/30/lessons/1845
import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> maps = new HashMap<>();
        
        for(int n : nums){
            maps.put(n, maps.getOrDefault(n, 1));
        }
        
        if(maps.size() > nums.length / 2)
            return nums.length / 2;
        else
            return maps.size();
        
    }
}
