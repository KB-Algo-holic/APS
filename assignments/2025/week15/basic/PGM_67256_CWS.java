// PGM 67256 - 키패드누르기
// 유형: 맨해튼거리
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/67256


import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        int leftHand = -1; //*
        int rightHand = -2; //#

        // 키패드 좌표 저장 (행, 열)
        HashMap<Integer, int[]> hm = new HashMap<>();
        hm.put(1, new int[]{0,0});
        hm.put(2, new int[]{0,1});
        hm.put(3, new int[]{0,2});
        hm.put(4, new int[]{1,0});
        hm.put(5, new int[]{1,1});
        hm.put(6, new int[]{1,2});
        hm.put(7, new int[]{2,0});
        hm.put(8, new int[]{2,1});
        hm.put(9, new int[]{2,2});
        hm.put(-1, new int[]{3,0}); // *
        hm.put(0, new int[]{3,1});
        hm.put(-2, new int[]{3,2}); // #

        for(int i = 0; i < numbers.length; i++){
            // 왼손
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                leftHand = numbers[i];
                sb.append("L");
                // 오른손
            }else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                rightHand = numbers[i];
                sb.append("R");
            }else{
                // 맨해튼거리로 거리계산
                int leftDist = Math.abs(hm.get(numbers[i])[0] - hm.get(leftHand)[0])
                        + Math.abs(hm.get(numbers[i])[1] - hm.get(leftHand)[1]);
                int rightDist = Math.abs(hm.get(numbers[i])[0] - hm.get(rightHand)[0])
                        + Math.abs(hm.get(numbers[i])[1] - hm.get(rightHand)[1]);

                if(leftDist > rightDist){ // 오른손이 가까운 경우
                    rightHand = numbers[i];
                    sb.append("R");
                }else if(leftDist < rightDist){ // 왼손이 가까운 경우
                    leftHand = numbers[i];
                    sb.append("L");
                }else{ // 거리가 같으면 주 손(hand) 사용
                    if(hand.equals("left")){
                        leftHand = numbers[i];
                        sb.append("L");
                    }else{
                        rightHand = numbers[i];
                        sb.append("R");
                    }
                }
            }
        }

        return sb.toString();
    }
}
