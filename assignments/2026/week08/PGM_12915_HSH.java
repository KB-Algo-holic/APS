
import java.util.Arrays;

public class PGM_12915_HSH {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] strings = { "abce", "abcd", "cdx" };
        int n = 2;

        String[] answer = solution(strings, n);

        for (String elem : answer) {
            System.out.print(elem + ", ");
        }
    }

    public static String[] solution(String[] strings, int n) {
        /***
         * 각 문자열의 n번째 문자 기준으로 오름차순을 넣는 거니까 
         * 앞서 푼 우선순위 큐로 풀어도 되긴 하지만, 더 간단하게는 Arrays.sort() 메서드에 Comparator를 넣어서 정렬하는 방법이 있음
         * sort 방식으로 처리할 때 
         * 1) 문자열 n번째 값 비교 -> a.charAt(n) - b.charAt(n) == n번째 문자 비교
         * 2) 둘이 동일할 때에는 문자열 전체 비교 -> a.compareTo(b)
         * 
         * 정렬 후 반환 
         */
        Arrays.sort(strings, (a, b) -> {
            // 1. n번째 문자 비교
            if (a.charAt(n) == b.charAt(n)) {
                // 2. 같으면 문자열 전체 비교
                return a.compareTo(b);
            }
            return a.charAt(n) - b.charAt(n);
        });

        return strings;
    }
}