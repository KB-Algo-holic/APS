package week07;

public class PGM_67256_HSH {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PGM_67256_HSH sol = new PGM_67256_HSH();
        int[] input = { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 };
        String input2 = "left";
        String result = sol.solution(input, input2);

        System.out.println(result);
    }
    
    private String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        /*
         * 0 1 2
         * 3 4 5
         * 6 7 8
         * * 9 #
         * 
         * 0이 0, 0으로 하고 왼손이 * 이니까 3, 0 오른손은 #이니까 3, 2로 시작
         */
        // 왼손 시작
        int leftX = 3, leftY = 0; // 행, 열
        //  오른손 시작
        int rightX = 3, rightY = 2; // 행, 열

        for (int num : numbers) {
            // num = 위치 정하기
            int[] targetPos = getTargetPosition(num);
            int x = targetPos[0];
            int y = targetPos[1];
            // 1, 4, 7 일 -> 무조건 왼쪽
            if (num == 1 || num == 4 || num == 7) {
                sb.append("L");
                leftX = x;
                leftY = y;
            }
            // 3, 6, 9 일때 -> 무조건 오른쪽
            else if (num == 3 || num == 6 || num == 9) {
                sb.append("R");
                rightX = x;
                rightY = y;
            } 
            // 2, 5, 8, 0 일때 -> 가까운 손으로 누르기 
            // 거리는 맨하탄 거리로 계산 -> |x1 - x2| + |y1 - y2| 
            else {
                // 2, 5, 8, 0 일때
                int leftHandDistance = Math.abs(leftX - x) + Math.abs(leftY - y);
                int rightHandDistance = Math.abs(rightX - x) + Math.abs(rightY - y);
                if (leftHandDistance < rightHandDistance) {
                    sb.append("L");
                    leftX = x;
                    leftY = y;
                } else if (leftHandDistance > rightHandDistance) {
                    sb.append("R");
                    rightX = x;
                    rightY = y;
                } else {
                    if (hand.equals("left")) {
                        sb.append("L");
                        leftX = x;
                        leftY = y;
                    } else {
                        sb.append("R");
                        rightX = x;
                        rightY = y;
                    }
                }
            }
        }
        return sb.toString();
    }

    private int[] getTargetPosition(int number) {
        /*
         * 0 1 2
         * 3 4 5
         * 6 7 8
         * * 9 #
         *
         * 좌표로해서 보여주기
         */
        switch (number) {
            case 1:
                return new int[] { 0, 0 };
            case 2:
                return new int[] { 0, 1 };
            case 3:
                return new int[] { 0, 2 };
            case 4:
                return new int[] { 1, 0 };
            case 5:
                return new int[] { 1, 1 };
            case 6:
                return new int[] { 1, 2 };
            case 7:
                return new int[] { 2, 0 };
            case 8:
                return new int[] { 2, 1 };
            case 9:
                return new int[] { 2, 2 };
            case 0:
                return new int[] { 3, 1 };
        }
        return new int[] { -1, -1 };
    }
}
