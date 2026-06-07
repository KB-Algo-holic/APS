// PGM 389478 - 택배상자꺼내기
// 그리디
// https://school.programmers.co.kr/learn/courses/30/lessons/389478

import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {

        int[][] arr = new int[n/w+1][w];
        int cnt = 1;
        int x = 0;
        int y = 0;

        for(int i = 0; i < n/w+1; i++){
            if(i%2 == 0){
                for(int j = 0; j < w; j++){

                    if(cnt == num){
                        x = i;
                        y = j;
                    }
                    arr[i][j] = cnt++;
                    if(cnt == n+1) {
                        i = n/w+1;
                        break;
                    }
                }
            }else{
                for(int j = w-1; j >= 0; j--){

                    if(cnt == num){
                        x = i;
                        y = j;
                    }
                    arr[i][j] = cnt++;
                    if(cnt == n+1) {
                        i = n/w+1;
                        break;
                    }
                }
            }
        }


        System.out.print(Arrays.deepToString(arr));

        int answer = 1;
        while(x < n/w){
            System.out.print(arr[x][y] + "  ");
            if(arr[x+1][y] == 0) break;
            else{
                x++;
                answer++;
            }

        }
        return answer;
    }
}