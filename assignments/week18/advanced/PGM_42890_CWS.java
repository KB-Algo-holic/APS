// PGM 42890 - 후보키
// 유형: 시뮬
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42890

import java.util.*;

class Solution {

    static List<int[]> list;   // 최소성 체크 리스트
    static String[][] rel;
    static int[] input, numbers;
    static int N, R, answer;

    public int solution(String[][] relation) {
        answer = 0;
        rel = relation;
        N = relation[0].length;
        input = new int[N];
        list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            input[i] = i;
        }

        // 1개 조합부터 N-1개 조합까지 확인
        for(int i = 1; i < N; i++){
            R = i;
            numbers = new int[i];
            combi(0,0);
        }

        // 후보키가 하나도 없으면
        if(answer == 0)
            answer = 1;

        return answer;
    }

    public static void combi(int cnt, int start){
        if(cnt == R){ // 조합 완성
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            boolean unique = true; // 유일성 체크

            //유일성 검사
            for(int i = 0; i < rel.length-1; i++){
                sb1 = new StringBuilder();
                for(int n1 = 0; n1 < numbers.length; n1++){
                    sb1.append(rel[i][numbers[n1]]);
                }
                for(int j = i+1; j < rel.length; j++){
                    sb2 = new StringBuilder();
                    for(int n2 = 0; n2 < numbers.length; n2++){
                        sb2.append(rel[j][numbers[n2]]);
                    }
                    //  유일성 위반
                    if(sb1.toString().equals(sb2.toString())){
                        unique = false;
                        i = rel.length-1; // 반복문 강제 종료
                        break;
                    }
                }
            }

            if(unique){ // 유일성 만족
                boolean minimal = true; // 최소성 체크
                // 이미등록된 키들과 비교
                for(int i = 0; i < list.size(); i++){
                    int count = 0;
                    for(int j = 0; j < list.get(i).length; j++){
                        for(int k = 0; k < numbers.length; k++){
                            if(list.get(i)[j] == numbers[k]){
                                count++; // 겹치는 컬럼 체크
                            }
                        }

                        if(count == list.get(i).length){
                            minimal = false;
                        }
                    }
                }
                if(minimal){
                    list.add(numbers.clone()); // 후보키 등록
                    answer++;
                }
            }
            return;
        }

        for(int i = start; i < N; i++){
            numbers[cnt] = input[i];
            combi(cnt+1, i+1);
        }
    }
}