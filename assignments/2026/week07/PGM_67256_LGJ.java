// PGM - 67256 키패드 누르기
// 시뮬레이션
// https://school.programmers.co.kr/learn/courses/30/lessons/67256

class Solution {

    public String solution(int[] numbers, String hand) {

        StringBuilder answer = new StringBuilder();

        int[] left = {3, 0};   // *
        int[] right = {3, 2};  // #

        for (int num : numbers) {

            int[] target = getPosition(num);

            if (num == 1 || num == 4 || num == 7) {
                answer.append("L");
                left = target;
            }

            else if (num == 3 || num == 6 || num == 9) {
                answer.append("R");
                right = target;
            }

            else {

                int leftDist = getDistance(left, target);
                int rightDist = getDistance(right, target);

                if (leftDist < rightDist) {
                    answer.append("L");
                    left = target;
                }

                else if (rightDist < leftDist) {
                    answer.append("R");
                    right = target;
                }

                else {
                    if (hand.equals("right")) {
                        answer.append("R");
                        right = target;
                    } else {
                        answer.append("L");
                        left = target;
                    }
                }
            }
        }

        return answer.toString();
    }


    private int[] getPosition(int num) {

        if (num == 0) return new int[]{3, 1};

        return new int[]{(num - 1) / 3, (num - 1) % 3};
    }


    private int getDistance(int[] a, int[] b) {

        return Math.abs(a[0] - b[0]) +
                Math.abs(a[1] - b[1]);
    }
}