import java.util.*;
import java.io.*;


class Solution {
    public Integer[] solution(int[] numlist, int n) {
        Integer[] arr = Arrays.stream(numlist).boxed().toArray(Integer[]::new);

        Arrays.sort(arr, (a, b) -> {
                    int tmpA = Math.abs(n - a);
                    int tmpB = Math.abs(n - b);
                    
                    if (tmpA == tmpB) {     // 거리가 같으면 큰 수 먼저
                        return b - a;
                    } 
                    return tmpA - tmpB;     // 아니면 가까운 수 먼저   
        });

        return arr;
    }
}
