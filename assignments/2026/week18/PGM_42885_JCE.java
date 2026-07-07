/*
프로그래머스 42885 구명조끼
그리디 - 투포인터
https://school.programmers.co.kr/learn/courses/30/lessons/42885?language=java
*/
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int leftIndex = 0; 
        int rightIndex = people.length - 1;
        
        while (leftIndex <= rightIndex) {
            if (people[leftIndex] + people[rightIndex] <= limit) {
                leftIndex++;
                rightIndex--;
                answer++;
            } else {
                rightIndex--;
                answer++;
            }
        }
        
        return answer;
    }
}
