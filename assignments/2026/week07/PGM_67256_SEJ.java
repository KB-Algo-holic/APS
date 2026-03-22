// 키패드 누르기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/67256
import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[][] memo = {
              {0,4,3,4,3,2,3,2,1,2,1,1}
            , {4,0,1,2,1,2,3,2,3,4,3,5}
            , {3,1,0,1,2,1,2,3,2,3,4,4}
            , {4,2,1,0,3,2,1,4,3,2,5,3}
            , {3,1,2,3,0,1,2,1,2,3,2,4}
            , {2,2,1,2,1,0,1,2,1,2,3,3}
            , {3,3,2,1,2,1,0,3,2,1,4,2}
            , {2,2,3,4,1,2,3,0,1,2,1,3}
            , {1,3,2,3,3,1,2,1,0,1,2,2}
            , {2,4,3,2,3,2,1,2,1,0,3,1}
            , {1,3,4,5,2,3,4,1,2,3,0,2}
            , {1,5,4,3,4,3,2,3,2,1,2,0}
        };
        
        int left  = 10;
        int right = 11;
        
        for(int n : numbers){
            // 1. 왼쪽 열의 3개의 숫자 1,4,7을 입력할 때는 왼손 사용
            String tmp = "";
            if(n==1 || n==4 || n==7){
                left = n;
                tmp = "L";
            }else if(n==3 || n==6 || n==9){
                right = n;
                tmp = "R";
            }else{
                // 더 가까운 곳 사용
                int dist1 = memo[left][n];
                int dist2 = memo[right][n];
                
                if(dist1<dist2){
                    left = n;
                    tmp = "L";
                }else if(dist2 < dist1){
                    right = n;
                    tmp = "R";
                }else{
                    if("right".equals(hand)){
                        right = n;
                        tmp="R";
                    }else{
                        left = n;
                        tmp = "L";
                    }
                }
            }
             sb.append(tmp);
        }
        
        return sb.toString();
    }
}