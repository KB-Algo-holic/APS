import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        // condition1 : 철수 덱의 최대공약수 && 영희 덱을 나눌 수 없는 수
        // condition2 : 영희 덱의 최대공약수 && 철수 덱을 나눌 수 없는 수
        // condition3 : c1 과 c2 중 큰 수

        // 정렬
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        //System.out.println(Arrays.toString(arrayA));

        // 각 덱의 최솟값 (가능한 공약수의 최댓값은 덱의 최솟값임)
        int lengthA = arrayA.length;
        int lengthB = arrayB.length;
        int minA = arrayA[0];
        int minB = arrayB[0];
        int maxAB = Math.max(minA, minB);
        int minAB = Math.min(minA, minB);

        // 최솟값의 약수 배열
        boolean[] dA = new boolean[maxAB+1];
        boolean[] dB = new boolean[maxAB+1];

        for (int i=maxAB; i>=Math.sqrt(minAB); i--) {
            // A 검사
            if (minA % i == 0) {
                dA[i] = true;
                dA[minA/i] = true;
            }
            // B 검사
            if (minB % i == 0) {
                dB[i] = true;
                dB[minB/i] = true;
            }
        }
//        System.out.println(Arrays.toString(dA));
//        System.out.println(Arrays.toString(dB));
        for (int i=maxAB; i>=2; i--) {
            // 검사
            boolean validate = true;
            if (dA[i] && !dB[i]) {
                // condition 1
                for (int j=1; j<lengthA; j++) {
                    int a = arrayA[j];
                    if (a % i != 0) {
                        validate = false;
                        break;
                    }
                }
                for (int j=1; j<lengthB; j++) {
                    int b = arrayB[j];
                    if (b % i == 0) {
                        validate = false;
                        break;
                    }
                }
            } else if (dB[i] && !dA[i]) {
                // condition 2
                for (int j=1; j<lengthA; j++) {
                    int a = arrayA[j];
                    if (a % i == 0) {
                        validate = false;
                        break;
                    }
                }
                for (int j=1; j<lengthB; j++) {
                    int b = arrayB[j];
                    if (b % i != 0) {
                        validate = false;
                        break;
                    }
                }
            } else validate = false;

            if (validate) return i;
        }


        return answer;
    }
}