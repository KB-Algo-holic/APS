// PGM 181844 - 배열의 원소 삭제하기
// 구현
//https://school.programmers.co.kr/learn/courses/30/lessons/181844

import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        int[] answer = {};
        List<Integer> rtnList = new ArrayList();
        boolean chk = true;
        for(int a : arr){
            chk = true;
            for(int d: delete_list ){
                if(a == d){
                    chk = false ;
                }
                
            }
            if(chk){
                rtnList.add(a);
            }
        }
        
        
        return rtnList.stream().mapToInt(i->i).toArray();
    }
}
