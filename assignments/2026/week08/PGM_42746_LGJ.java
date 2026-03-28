// PGM - 42746 가장 큰 수
// 구현 - 정렬 (문자열)
// https://school.programmers.co.kr/learn/courses/30/lessons/42746


import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] stringNumbers = new String[numbers.length];
        for (int i=0; i<numbers.length; i++) {
            stringNumbers[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(stringNumbers, (s1, s2) -> (s2+s1).compareTo(s1+s2));

        return  stringNumbers[0].equals("0") ? "0" : String.join("", stringNumbers);
    }
}