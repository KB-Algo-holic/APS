package week16;
import java.util.HashSet;

public class PGM_131701_HSH {

    public static void main(String[] args) {
        PGM_131701_HSH sol = new PGM_131701_HSH();
        int[] numbers = {7, 9, 1, 1, 4};
        System.out.println(sol.solution(numbers));
    }
    public int solution(int[] numbers) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>(); // 중복 제거용
        // 슬라이딩 윈도우
        for (int i = 1; i <= numbers.length; i++) {
            int sum = 0; // 슬라이딩 갯수만큼 합계 계산할 것 
            for (int j = 0; j < numbers.length; j++) {
                if(j == 0) {
                    for (int k = 0; k < i; k++) {
                        sum += numbers[k];
                    }
                } else {
                    sum += numbers[(j + i - 1) % numbers.length]; // 슬라이딩 윈도우로 다음 숫자 더하기
                    sum -= numbers[(j - 1) % numbers.length]; // 슬라이딩 윈도우로 이전 숫자 빼기
                }
                set.add(sum); // 합계 정리
            }
        }

        answer = set.size(); // 중복 제거된 합계의 개수ß
        return answer;
    }

}