// PGM 67256 - 키패드 누르기
// 학습
// https://school.programmers.co.kr/learn/courses/30/lessons/67256
class Solution {

    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        // 시작 위치: 왼손은 '*' → 9, 오른손은 '#' → 11로 가정 (0-based index)
        int left = 9, right = 11;

        for (int num : numbers) {
            // 숫자 0은 키패드 상 위치 11번으로 변환
            if (num == 0) num = 11;
            num--; // 0-based 인덱스로 변환

            switch (num % 3) {
            case 0:
                // 1, 4, 7 → 왼손 사용
                sb.append("L");
                left = num;
                break;
            case 2:
                // 3, 6, 9 → 오른손 사용
                sb.append("R");
                right = num;
                break;
            default: 
                // 2, 5, 8, 0 → 거리 계산 후 더 가까운 손 선택
                int leftDist = Math.abs(left / 3 - num / 3) + Math.abs(left % 3 - num % 3);
                int rightDist = Math.abs(right / 3 - num / 3) + Math.abs(right % 3 - num % 3);

                if (leftDist < rightDist || (leftDist == rightDist && hand.equals("left"))) {
                    // 왼손이 더 가깝거나 거리 같고 왼손잡이일 경우
                    sb.append("L");
                    left = num;
                } else {
                    // 오른손이 더 가깝거나 거리 같고 오른손잡이일 경우
                    sb.append("R");
                    right = num;
                }
            }
        }

        return sb.toString();
    }
}
