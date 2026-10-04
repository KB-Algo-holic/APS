// PGM 64065 튜플
// 구현 및 스택
// https://school.programmers.co.kr/learn/courses/30/lessons/64065

import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer;
        int length = s.length();
        int n = 0;

        String transString = s.substring(1, length-1); // 바깥 괄호 제거
        List<List<Integer>> tuples = new ArrayList<>();
        // 길이 1 ~ n까지인 List가 n개
        Stack<Character> stack = new Stack<>();
        //System.out.println(transString);

        List<Integer> tuple = new ArrayList<>();
        for (char ch: transString.toCharArray()) {
            if (ch == '}') {

                String num = "";
                while (!stack.isEmpty()) {
                    char top = stack.pop();
                    if (top == '{') break; //첫번째 열린 괄호에서 종료

                    if (top == ',') {
                        //지금까지의 num 출력
                        //System.out.println(num);
                        tuple.add(0, Integer.parseInt(num));
                        num = "";
                    } else {
                        num = top + num;
                    }
                }
                if (num.length() != 0) {
                    //System.out.println("END");
                    //System.out.println(num);
                    tuple.add(0, Integer.parseInt(num));
                    num = "";
                }
                tuples.add(0, tuple);
                tuple = new ArrayList<>();
            } else if (stack.isEmpty() && ch == ',') {
                continue;
            } else {
                stack.push(ch);
            }
        }
        tuples.sort((a, b) -> a.size() - b.size()); // 길이 별 정렬
        n = tuples.size(); // 총 개수
        answer = new int[n];
        //System.out.println(tuples);

        Set<Integer> set = new HashSet<>();
        for (int i=0; i<n; i++) {
            tuple = tuples.get(i);
            for (int num : tuple) {
                if (!set.contains(num)) {
                    answer[i] = num;
                    set.add(num);
                }

            }

        }

        return answer;
    }
}