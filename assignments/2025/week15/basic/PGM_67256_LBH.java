// PGM 67256 - 키패드 누르기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/67256

class Solution {

    public String solution(int[] numbers, String hand) {
        String answer = "";

        int[] left = {3,0};
        int[] right = {3,2};

        int[] pos = {0, 0};
        int leftDist, rightDist = 0;

        for(int i = 0; i < numbers.length; i++) {
            if(0 == numbers[i]) {
                pos[0] = 3; pos[1] = 1;
            } else {
                pos[0] = (numbers[i] - 1) / 3;
                pos[1] = (numbers[i] - 1) % 3;
            }

            if(1 == numbers[i] || 4 == numbers[i] || 7 == numbers[i]) {
                left[0] = pos[0]; left[1] = pos[1];
                answer += "L";
                continue;
            } else if(3 == numbers[i] || 6 == numbers[i] || 9 == numbers[i]) {
                right[0] = pos[0]; right[1] = pos[1];
                answer += "R";
                continue;
            }

            leftDist = Math.abs(pos[0] - left[0]) + Math.abs(pos[1] - left[1]);
            rightDist = Math.abs(pos[0] - right[0]) + Math.abs(pos[1] - right[1]);

            if(leftDist < rightDist) {
                left[0] = pos[0]; left[1] = pos[1];
                answer += "L";
            } else if(leftDist > rightDist) {
                right[0] = pos[0]; right[1] = pos[1];
                answer += "R";
            } else {
                if("left".equals(hand)) {
                    left[0] = pos[0]; left[1] = pos[1];
                    answer += "L";
                } else {
                    right[0] = pos[0]; right[1] = pos[1];
                    answer += "R";
                }
            }
        }

        return answer;
    }
}