// PGM_67256 키패드 누르기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/67256

class Solution {
    
    
    public static int[][] key_pad = {
            {1, 2, 3}
            ,{4, 5, 6}
            ,{7, 8, 9}
            ,{10, 11, 12}
        };
    
    public String solution(int[] numbers, String hand) {
        int left_now = 10; // *을 10 치환
        int right_now = 12; // #을 12 치환
        StringBuilder answer = new StringBuilder();
        for(int i = 0 ; i< numbers.length; i++){
            if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                answer.append("R");
                right_now = numbers[i];
            }
            else if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                answer.append("L");
                left_now = numbers[i];
            }
            else {
                if(numbers[i] == 0)
                    numbers[i] = 11; // 0을 11 치환
                answer = answer.append(WhichHand(numbers[i], hand, left_now, right_now));
                if(answer.charAt(i) == 'R')
                    right_now = numbers[i];
                else
                    left_now = numbers[i];
            }
        }
        return answer.toString();
    }
    
    public String WhichHand(int button, String mainHand, int left_now, int right_now){
        int l_distance = 0;
        int r_distance = 0;
        l_distance = checkDistance(left_now, button);
        r_distance = checkDistance(right_now, button);
        if(l_distance > r_distance)
            return "R";
        else if(l_distance < r_distance)
            return "L";
        else{
            if(mainHand.equals("left"))
                return "L";
            else
                return "R";
        }
    }
    
    public int checkDistance(int key_now, int input_btn){
        int distance = 0;
        int nowx = 0;
        int nowy = 0;
        int inputx = 0;
        int inputy = 0;
        for(int i = 0; i < 4;i++){
            for(int j = 0; j < 3; j++){
                if(key_pad[i][j] == key_now){
                    nowx = i;
                    nowy = j;
                }
                if(key_pad[i][j] == input_btn){
                    inputx = i;
                    inputy = j;
                }
            }
        }
        distance = Math.abs(nowx - inputx) + Math.abs(nowy - inputy);
        return distance;
    }
}
