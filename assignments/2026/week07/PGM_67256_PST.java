// PGM 67256 - 키패드 누르기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/67256
class Solution {
    public String solution(int[] numbers, String hand) {
        char[] strArray = new char[numbers.length];

        int posL = 10;
        int posR = 12;

        for(int i=0;i<numbers.length;i++){
            switch (numbers[i]) {
                case 1,4,7 :
                    strArray[i] = 'L';
                    posL = numbers[i];
                    break;
                case 3,6,9 :
                    strArray[i] = 'R';
                    posR = numbers[i];
                    break;
                case 2,5,8,0 :

                    int ld = getDistance(posL, numbers[i]);
                    int rd = getDistance(posR, numbers[i]);

                    if (ld < rd) {
                        strArray[i] = 'L';
                        posL = numbers[i];
                    }  else if (rd < ld) {
                        strArray[i] = 'R';
                        posR = numbers[i];
                    } else {
                        if (hand.equals("left")) {
                            strArray[i] = 'L';
                            posL = numbers[i];
                        } else {
                            strArray[i] = 'R';
                            posR = numbers[i];
                        }
                    }
            }
        }

        return new String(strArray);
    }

    private int getDistance(int current, int target) {

        if (current == 0) current = 11;
        if (target == 0) target = 11;

        int curX = (current - 1) / 3;
        int curY = (current - 1) % 3;
        int desX = (target - 1) / 3;
        int desY = (target - 1) % 3;

        return Math.abs(curX - desX) + Math.abs(curY - desY);
    }
}