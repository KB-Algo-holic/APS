// PGM 72412 - 순위 검색
// 유형: 이분탐색
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/72412

import java.util.*;

class Solution {

    static String s1,s2,s3,s4;     // 문자열 구분을 위한 문자열 선언
    static int s5, sum;
    static HashMap<String, List<Integer>> hm;

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        hm = new HashMap<>();
        StringTokenizer st;

        // 정보 입력
        for(int i = 0; i < info.length; i++){
            st = new StringTokenizer(info[i]);
            s1 = st.nextToken();
            s2 = st.nextToken();
            s3 = st.nextToken();
            s4 = st.nextToken();
            s5 = Integer.parseInt(st.nextToken());
            word1("","info"); // 조합 생성
        }

        // 각 조합 리스트 정렬
        for(String s : hm.keySet()){
            Collections.sort(hm.get(s));
        }

        // 쿼리 처리
        for(int i = 0; i < query.length; i++){
            st = new StringTokenizer(query[i]);
            sum = 0;
            s1 = st.nextToken();
            st.nextToken();  // and 제거
            s2 = st.nextToken();
            st.nextToken();
            s3 = st.nextToken();
            st.nextToken();
            s4 = st.nextToken();
            s5 = Integer.parseInt(st.nextToken());
            word1("","query"); // 쿼리 탐색
            answer[i] = sum;
        }

        return answer;
    }

    private static void word1(String word, String chk){
        if(s1.equals("cpp")){
            word = "c";
            word2(word, chk);
        }else if(s1.equals("java")){
            word = "j";
            word2(word, chk);
        }else if(s1.equals("python")){
            word = "p";
            word2(word, chk);
        }else{ // "-"인 경우 (모든 경우 허용)
            word2("c",chk); word2("j",chk); word2("p",chk);
        }
    }

    private static void word2(String word, String chk){
        if(s2.equals("backend")){
            word += "b";
            word3(word,chk);
        }else if(s2.equals("frontend")){
            word += "f";
            word3(word,chk);
        }else{
            word3(word+"b",chk); word3(word+"f",chk);
        }
    }

    private static void word3(String word, String chk){
        if(s3.equals("junior")){
            word += "j";
            word4(word,chk);
        }else if(s3.equals("senior")){
            word += "s";
            word4(word,chk);
        }else{
            word4(word+"j",chk); word4(word+"s",chk);
        }
    }

    private static void word4(String word, String chk){
        if(s4.equals("chicken")){
            word += "c";
            if(chk.equals("info")){ // info 입력일 때
                hm.computeIfAbsent(word,k -> new ArrayList<>()).add(s5);
            }else{ // query 탐색일 때
                List<Integer> list = hm.get(word);
                if(list != null){
                    sum += list.size() - word5(list,s5); // 이분 탐색
                }
            }

        }else if(s4.equals("pizza")){
            word += "p";
            if(chk.equals("info")){
                hm.computeIfAbsent(word,k -> new ArrayList<>()).add(s5);
            }else{
                List<Integer> list = hm.get(word);
                if(list != null){
                    sum += list.size() - word5(list,s5);
                }
            }
        }else{
            if(chk.equals("info")){
                hm.computeIfAbsent(word+"c",k -> new ArrayList<>()).add(s5);
                hm.computeIfAbsent(word+"p",k -> new ArrayList<>()).add(s5);
            }else{
                List<Integer> list = hm.get(word+"c");
                if(list != null){
                    sum += list.size() - word5(list,s5);
                }
                list = hm.get(word+"p");
                if(list != null){
                    sum += list.size() - word5(list,s5);
                }
            }
        }
    }

    // 점수 기준 이분 탐색
    private static int word5(List<Integer> list, int s5){
        int l = 0;
        int r = list.size();

        // s5 이상인 첫 번째 인덱스를 찾음
        while(l < r){
            int mid = (l+r)/2;
            if(list.get(mid) < s5){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }
}
