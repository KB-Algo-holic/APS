// PGM 72411 - 메뉴 리뉴얼
// 유형: 백트래킹
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/72411

import java.util.*;

class Solution {

    static String[] input, numbers;
    static int N, R;
    static HashMap<String, Integer> hm;
    static HashMap<Integer, Integer> keyHm;

    public String[] solution(String[] orders, int[] course) {

        hm = new HashMap<>();
        keyHm = new HashMap<>();

        for(int i : course){
            keyHm.put(i, 2);
        }

        // 모든 주문에 대한 조합
        for(int i = 0; i < orders.length; i++){
            // 문자 분리
            input = new String[orders[i].length()];
            for(int j = 0; j < orders[i].length(); j++){
                input[j] = orders[i].charAt(j) + "";
            }

            // 사전순 조합을 위해 정렬
            Arrays.sort(input);

            N = orders[i].length();

            // 각 코스 길이 R에 대해 조합 생성
            for(int j = 0; j < course.length; j++){
                R = course[j];
                numbers = new String[R];
                combi(0, 0);
            }
        }
        List<String> list = new ArrayList<>();
        for(String s : hm.keySet()){
            //해당 길이에서 가장 많이 나온 개수
            if(hm.get(s) == keyHm.get(s.length())){
                list.add(s);
            }
        }

        Collections.sort(list);

        return list.toArray(new String[0]);
    }

    // 조합 생성
    private static void combi(int cnt, int start){
        if(cnt == R){
            StringBuilder sb = new StringBuilder();

            for(String s : numbers){
                sb.append(s);
            }
            String key = sb.toString();
            // 등장 횟수
            hm.put(key, hm.getOrDefault(key, 0) + 1);
            // 조합 수 갱신
            if(hm.get(key) > keyHm.get(R)){
                keyHm.put(R, hm.get(key));
            }
            return;
        }

        // 백트래킹
        for(int i = start; i < N; i++){
            numbers[cnt] = input[i];
            combi(cnt + 1, i + 1);
        }
    }
}
