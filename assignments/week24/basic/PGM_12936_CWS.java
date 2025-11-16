import java.util.*;

class Solution {

    public int[] solution(int n, long k) {

        int[] answer = new int[n];

        long[] arr = new long[n+1]; //팩토리얼 저장
        arr[0] = 1;

        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            arr[i] = arr[i-1] * i;
            list.add(i); // 순열에 사용할 숫자
        }

        k--;

        for(int i = 0; i < n; i++){

            int index = (int)(k / arr[n - 1 - i]);

            k %= arr[n - 1 - i];

            // 인덱스 숫자 결과에 넣기
            answer[i] = list.remove(index);
        }

        return answer;
    }
}