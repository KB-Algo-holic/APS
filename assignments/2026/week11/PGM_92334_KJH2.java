// PGM_92334 신고결과 받기
// 인접행렬이랑 맵으로 구현...
// school.programmers.co.kr/learn/courses/30/lessons/92334
import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length]; // 메일받는 횟수
        int[] rep_cnt = new int[id_list.length]; // 각 유저별로 신고당한 횟수
        int[][] array = new int[id_list.length][id_list.length]; //누가 누구를 신고했는지 array에 저장
        HashMap<String, Integer> id_map = new HashMap<>();
        
        for(int i = 0 ; i < id_list.length ; i++){
            id_map.put(id_list[i], i);
        }
        
        for(int i = 0; i < report.length; i++){
            String[] repstr = report[i].split(" ");
            array[id_map.get(repstr[0])][id_map.get(repstr[1])] = 1;
        }
        
        // 신고당한 횟수를 종합해서 저장.. 
        for(int i = 0 ; i < array.length ; i++){
            for(int j = 0 ; j < array.length; j++){
                if(array[i][j] == 1){
                    rep_cnt[j]++;
                }
            }
        }
        
        for(int i = 0; i < rep_cnt.length; i++){
            if(rep_cnt[i] >= k){
                    for(int n = 0; n < array.length; n++){
                        if(array[n][i] == 1){
                            answer[n]++;
                        }
                    }
            }
            
        }
              
        
        return answer;
    }
}
