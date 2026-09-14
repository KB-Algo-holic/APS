// PGM - 131127 할인행사
// 슬라이딩 윈도우
// https://school.programmers.co.kr/learn/courses/30/lessons/131127
import java.util.HashMap;
import java.util.Map;

public class PGM_131127_YHS {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<discount.length; i++){
            // for(int j=i; j<Integer.min(i+10, discount.length); j++){
            //     String item = discount[j];
            //     if(map.get(item) == null){
            //         map.put(item, 1);
            //     }else{
            //         map.put(item, map.get(item)+1);
            //     }
            // }
            // System.out.println(map);
            String item = discount[i];
            if(map.get(item) == null){
                map.put(item, 1);
            }else{
                map.put(item, map.get(item)+1);
            }
            if(i>=10){
                String removeItem = discount[i-10];
                map.put(removeItem, map.get(removeItem)-1);
            }

            boolean isPosible = true;
            for(int j=0; j<want.length; j++){
                if(map.get(want[j]) == null) {
                    isPosible = false;
                    break;
                }
                if(map.get(want[j]) < number[j]){
                    isPosible = false;
                    break;
                }
            }
            if(isPosible) answer++;
        }

        return answer;
    }
}
