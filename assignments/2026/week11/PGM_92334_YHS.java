import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// PGM - 92334 L1_신고결과받기
// 해시
// https://school.programmers.co.kr/learn/courses/30/lessons/92334
public class PGM_92334_YHS {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Set<String> set = new HashSet<>();

        // 중복신고 제거
        for(int i=0; i<report.length; i++){
            set.add(report[i]);
        }

        Map<String, Integer> map = new HashMap<>();
        for(String s : set){
            String from = s.split(" ")[0];
            String to   = s.split(" ")[1];

            if(map.get(to) == null){
                map.put(to, 1);
            }else{
                map.put(to, map.get(to)+1);
            }
        }

        Map<String, Integer> result = new HashMap<>();

        for(String s : set){
            String from = s.split(" ")[0];
            String to   = s.split(" ")[1];

            if(map.get(to) != null && map.get(to) >= k){
                if(result.get(from) == null){
                    result.put(from, 1);
                }else{
                    result.put(from, result.get(from)+1);
                }
            }
        }

        for(int i=0; i<id_list.length; i++){
            if(result.get(id_list[i]) == null){
                answer[i] = 0;
            }else{
                answer[i] = result.get(id_list[i]);
            }
        }

        return answer;
    }
}
