package week18;

import java.util.Arrays;

public class PGM_42885_HSH {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;

        for(i = 0; i < j; j--) {
            if (people[i] + people[j] <= limit) {
                i++; // 최소 + 최대 무게로 했을때에도 범위 안에 있다면 사람을 더 태울 수 있음
            }
        }
        return people.length - i; // 인당 하나의 구명보트로 체크했을 대, 구명보트 전체수 - 제한 내 태운 횟수

    }
}
