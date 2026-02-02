// PGM 43163 - 단어 변환
// 유형: DFS/BFS
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43163

import java.util.*;

class Solution {

    static boolean[] checked; //체크 배열
    static Queue<String> queue; //탐색 단어 큐
    static int answer; //결과값

    public int solution(String begin, String target, String[] words) {
        checked = new boolean[words.length];
        queue = new LinkedList<>();

        for(int i = 0; i < words.length; i++){
            boolean wordCheck = false;
            for(int j = 0; j < begin.length(); j++){
                if(begin.charAt(j) != words[i].charAt(j) && wordCheck){
                    wordCheck = false;
                    j = begin.length();
                }else if(begin.charAt(j) != words[i].charAt(j)){
                    wordCheck = true;
                }
            }
            if(wordCheck){
                answer = Integer.MAX_VALUE;
                checked[i] = true;
                queue.offer(words[i]);
                move(begin, target, words, 1);
                checked[i] = false;
            }
        }
        if(answer == Integer.MAX_VALUE){
            return 0;
        }else{
            return answer;
        }
    }

    public static void move(String begin, String target, String[] words, int cnt){
        if(queue.isEmpty()){
            return;
        }

        //다음단어 큐에서 꺼냄
        begin = queue.poll();

        //결과값에 최소값 넣기
        if(begin.equals(target)){
            answer = Math.min(answer, cnt);
        }

        for(int i = 0; i < words.length; i++){
            boolean wordCheck = false;
            for(int j = 0; j < begin.length(); j++){
                //두 글자 이상 다른경우
                if(begin.charAt(j) != words[i].charAt(j) && wordCheck && !checked[i]){
                    wordCheck = false;
                    j = begin.length();
                //한 글자만 다른경우
                }else if(begin.charAt(j) != words[i].charAt(j) && !checked[i]){
                    wordCheck = true;
                }
            }

            //다음 단어 이동
            if(wordCheck){
                checked[i] = true;
                queue.offer(words[i]);
                move(begin, target, words, cnt+1);
                checked[i] = false;
            }

        }

    }
}