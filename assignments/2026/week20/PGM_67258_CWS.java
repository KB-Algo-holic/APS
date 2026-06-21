// PGM 67258 - 보석쇼핑
// 투포인터/슬라이딩윈도우
// https://school.programmers.co.kr/learn/courses/30/lessons/67258

import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {1,1};

        HashSet<String> hs = new HashSet<>();
        for(String gem : gems){
            hs.add(gem);
        }

        int l = 0;
        int r = 0;
        int min = Integer.MAX_VALUE;

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put(gems[0], 1);

        if(hs.size() != 1){
            while(r != gems.length - 1){

                r += 1;

                if(hm.get(gems[r]) == null){
                    hm.put(gems[r], 1);
                }else{
                    hm.put(gems[r], hm.get(gems[r]) + 1);
                }

                if(hm.size() == hs.size()){
                    while(true){
                        if(hm.get(gems[l]) > 1){
                            hm.put(gems[l], hm.get(gems[l]) - 1);
                            l += 1;
                        }else{
                            hm.clear();
                            if(r - l < min){
                                answer[0] = l + 1;
                                answer[1] = r + 1;
                                min = r - l;
                            }
                            break;
                        }
                    }
                    l += 1;
                    r = l;
                    hm.put(gems[r] ,1);
                }

            }
        }

        return answer;
    }
}