// PGM 42746 - 가장 큰 수
// 정렬
// https://school.programmers.co.kr/learn/courses/30/lessons/42746

import java.util.*;

class Solution {
    public String solution(int[] numbers) {


        int[][] arr = new int[numbers.length][2];

        //비교를 위해 자릿수 맞춰줌
        for(int i = 0; i < numbers.length; i++){
            arr[i][0] = numbers[i];
            if(numbers[i] < 10){
                arr[i][1] = numbers[i] * 111111;
            }else if(numbers[i] < 100){
                arr[i][1] = numbers[i] * 10000 + numbers[i] * 100 + numbers[i];
            }else if(numbers[i] < 1000){
                arr[i][1] = numbers[i] * 1000 + numbers[i];
            }else{
                arr[i][1] = 10;
            }
        }

        //배열 정렬
        Arrays.sort(arr, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] != b[0]){
                    return Integer.compare(b[1], a[1]);
                }else{
                    return Integer.compare(b[0], a[0]);
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        String answer = "0";
        if(arr[0][0] != 0){
            for(int i = 0; i < numbers.length; i++){
                sb.append(arr[i][0]);
            }
            answer = sb.toString();
        }


        return answer;
    }
}