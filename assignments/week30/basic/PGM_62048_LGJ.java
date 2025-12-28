// PGM - 62048 멀쩡한 사각형
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/62048


class Solution {
    public long solution(int w, int h) {
        long answer = (long) w*h;
        // 대각선의 좌표 이동 반경 : 0~w, 0~h
        // 대각선이 내부 사각형의 변을 지나는 횟수는 각각 w-1, h-1
        // *1 + (w-1) + (h-1) = w+h-1 (시작 사각형 + 대각선이 지나는 사각형의 개수)
        // 위 수식에서 중복값을 제거해줘야함
        // 중복 : 각 사각형의 우하단 꼭지점을 지나는 케이스
        // 중복은 최대공약수만큼 발생함
        // **(w+h-1) - gcd(w, h)
        // 마지막으로 최대공약수는 우측 최하단 꼭지점을 포함하는데 이는 내부 사각형에 영향도가 없으므로 1을 빼줘야함
        // *** 사용 불가 사각형의 개수 = (w+h-1) - (gcd(w, h)-1) = w + h - gcd(w,h)

        long impossible = w+h-gcd(w, h);

        return answer-impossible;
    }

    public long gcd(int w, int h) {
        // 유클리드 호제법(O(log n)) 사용 시 시간복잡도 최소화
        long min = Math.min(w, h);
        for (long i=min; i>1; i--) {
            if (w%i==0 && h%i==0) return i;
        }

        return 1;
    }
}