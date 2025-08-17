// PGM 340210 - 수식 복원하기
// 유형: 진법변환
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/340210

import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        Queue<String> queue = new LinkedList<>();
        StringTokenizer st;
        int[] arr = new int[10];
        int max = 1; //가능한 진법
        int arrMax = 1; //체크할 진법
        //가능한 진법 찾기 *존재하는 숫자중 가장 큰 수 + 1 ex) 17 -> 8진법부터, 52 -> 6진법부터 가능
        for(int i = 0; i < expressions.length; i++){
            for(int j = 0; j < expressions[i].length(); j++){
                for(int k = 2; k <= 9; k++){
                    if(expressions[i].charAt(j) - '0' == k){
                        max = Math.max(max, k);
                    }
                }
            }
        }

        //예제의 결과값이 모두 X인경우 대비
        for(int i = max+1; i <= 9; i++){
            arr[i] = 1;
        }


        for(int i = 0; i < expressions.length; i++){
            for(int j = max + 1; j <= 9; j++){
                //진수로 변환
                st = new StringTokenizer(expressions[i]);
                int numA1 = Integer.parseInt(st.nextToken());
                String cir = st.nextToken();
                int numA2 = Integer.parseInt(st.nextToken());
                st.nextToken(); // '=' 제거
                String numA3 = st.nextToken();
                if(numA3.equals("X")){
                    queue.offer(numA1 + " " + cir + " " + numA2 + " = " + "X");
                    break;
                }

                //진법 변환
                int numB1 = Integer.parseInt(numA1+"", j);
                int numB2 = Integer.parseInt(numA2+"", j);
                int numB3 = Integer.parseInt(numA3+"", j);


                //가능한 진법은 arr배열에 1추가
                if(cir.equals("+")){
                    if(numB1 + numB2 == numB3){
                        arr[j] += 1;
                        arrMax = Math.max(arrMax, arr[j]);
                    }
                }else{
                    if(numB1 - numB2 == numB3){
                        arr[j] += 1;
                        arrMax = Math.max(arrMax, arr[j]);
                    }
                }
            }
        }

        List<String> list = new ArrayList<>();
        while(!queue.isEmpty()){
            String s = queue.poll();
            st = new StringTokenizer(s);
            int numA1 = Integer.parseInt(st.nextToken());
            String cir = st.nextToken();
            int numA2 = Integer.parseInt(st.nextToken());
            st.nextToken(); // '=' 제거
            String numA3 = st.nextToken();

            for(int j = 2; j <= 9; j++){
                if(arr[j] == arrMax){
                    String numB = "";
                    int numB1 = Integer.parseInt(numA1+"", j);
                    int numB2 = Integer.parseInt(numA2+"", j);

                    if(cir.equals("+")){
                        numB = Integer.toString((numB1+numB2), j);
                    }else{
                        numB = Integer.toString((numB1-numB2), j);
                    }

                    if(numA3.equals("X")){
                        numA3 = numB;
                    }else{
                        if(!numA3.equals(numB)){
                            numA3 = "?";
                            break;
                        }
                    }
                }
            }
            list.add(numA1 + " " + cir + " " + numA2 + " " + "=" + " " + numA3);
        }

        String[] answer = list.toArray(new String[0]);
        return answer;
    }

}