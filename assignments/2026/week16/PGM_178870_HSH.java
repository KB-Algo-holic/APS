package week16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PGM_178870_HSH {
    public static void main(String[] args) {
        PGM_178870_HSH sol = new PGM_178870_HSH();
        int[] numbers = {1, 2, 3, 4, 5};
        int k = 7;
        System.out.println(sol.solution(numbers,k));
    }
    /*
    기존 수열에서 임의의 두 인덱스의 원소와 그 사이의 원소를 모두 포함한 부분 수열
    부분 수열의 합은 k
    k
    */
    public int[] solution(int[] sequence,int k) {
        List<int[]> answer = new ArrayList<>();

        int left = 0;
        int right = 0;
        int minSum = 1000000001;
        int sum = sequence[0];
        int n = sequence.length;

        Arrays.sort(sequence);

        while(left <= right && right < n) {
            if(left == n && right == n) {
                break;
            }
            if(sum == k) {
                answer.add(new int[]{left, right});
                sum -= sequence[left];
                left++;
            } else {
                if(sum < k) {
                    if(right < n - 1) {
                        sum += sequence[right + 1];
                        right++;
                    } else {
                        break;
                    }
                } else {
                    if(left < n) {
                        sum -= sequence[left];
                        left++; 
                    }
                }
            }
        }

        int start = 0;
        int end = 0;
        for(int[] arr : answer) {
            if(arr[1] - arr[0] < minSum) {
                minSum = arr[1] - arr[0];
                start = arr[0];
                end = arr[1];
            }
        }
        return new int[] { start, end };
    }

}
