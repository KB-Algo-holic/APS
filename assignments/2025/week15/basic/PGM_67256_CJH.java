// PGM 67256 - 키패드 누르기
// 유형 : 문자열
// 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/67256?language=java

public class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int cur_left[] = new int[2];
        int cur_right[] = new int[2];
        int pad[][] = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
        
        cur_left[0] = cur_right[0] = 3;
        cur_left[1] = 0;
        cur_right[1] = 2;
        
        int len = numbers.length;
        
        for(int i=0; i<len; i++){
            int num = numbers[i];
            if(num == 1 || num == 4 || num == 7){
                cur_left[0] = pad[num][0];
                cur_left[1] = pad[num][1];
                answer += "L";
            }else if(num == 3 || num == 6 || num == 9){
                cur_right[0] = pad[num][0];
                cur_right[1] = pad[num][1];
                answer += "R";
            }else{
                double left_dist = Math.ceil(Math.sqrt(Math.pow(cur_left[0] - pad[num][0],2) + Math.pow(cur_left[1] - pad[num][1], 2)));
                double right_dist = Math.ceil(Math.sqrt(Math.pow(cur_right[0] - pad[num][0],2) + Math.pow(cur_right[1] - pad[num][1], 2)));
                
                if((left_dist > right_dist) || ((left_dist == right_dist) && hand.equals("right"))){
                    cur_right[0] = pad[num][0];
                    cur_right[1] = pad[num][1];
                    answer += "R";
                }else{
                    cur_left[0] = pad[num][0];
                    cur_left[1] = pad[num][1];
                    answer += "L";
                }
            }
        }
        return answer;
    }
}