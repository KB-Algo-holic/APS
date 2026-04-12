// PGM 1845 - 폰켓몬
// 해시
// https://school.programmers.co.kr/learn/courses/30/lessons/1845

import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int size = nums.length;
        
        for(int i=0;i<size;i++)
        {
            map.put(nums[i],i);
        }
        
        int answer = 0;
        
        if(map.size() < size/2)
            answer = map.size();
        else
            answer = size/2;
        return answer;
    }
}
