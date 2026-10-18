// https://school.programmers.co.kr/learn/courses/30/lessons/340198?language=java

import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;

        List<Integer> list = new ArrayList<>();

        int n = park.length;
        int m = park[0].length;
        for(int i = 0 ; i<n ; i++){
            for(int j = 0; j<m; j++){
                if(park[i][j].equals("-1")){

                    for(int k = 0; k<mats.length; k++){
                        int num = mats[k];
                        int count = 0 ;
                        for(int x = i; x<i+num; x++){
                            for(int y = j; y<j+num; y++){
                                if(x < 0 || x >= n || y < 0|| y >= m){
                                    continue;
                                }
                                if(park[x][y].equals("-1")){
                                    count++;
                                }
                            }
                        }
                        
                        if(count == num*num){
                            list.add(num);
                        }
                    }
                }
            }
        }
        
        if(list.size() == 0){
            answer = -1;
        }else{
            Collections.sort(list);
            answer = list.get(list.size()-1);
        }
        return answer;
    }
}
