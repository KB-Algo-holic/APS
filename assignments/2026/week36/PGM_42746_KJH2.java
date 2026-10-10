// PGM 42746 가장 큰 수
// Comparator 사용..
//https://school.programmers.co.kr/learn/courses/30/lessons/42746

import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] strings = new String[numbers.length];
        int i = 0;
        for(int n : numbers){
            strings[i++] = String.valueOf(n);
        }
        
        Arrays.sort(strings, new Comparator<String>(){
            public int compare(String a, String b){
                return (b + a).compareTo(a + b);
            }
        });
        if(strings[0].equals("0"))
            return "0";
        String str = new String();
        for(String s : strings){
            str += s;
        }
        
        return str;
    }
}
