// PGM 42860 - 조이스틱
// 그리디
// https://school.programmers.co.kr/learn/courses/30/lessons/42860


import java.util.*;

class Solution {
    public int solution(String name) {

        int answer = 0;
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i < name.length(); i++){
            if(name.charAt(i) != 'A'){
                q.offer(i);
            }
        }
        System.out.println(q);

        int l = 0;
        int r = 0;

        if(q.size() == name.length() - 1){
            answer += name.length() - 1;
        }else{
            while(!q.isEmpty()){
                r = q.poll();
                System.out.println("1 : " + (r-l));
                System.out.println("2 : " + (name.length() - r + l));

                if(r-l > name.length()-r+l){
                    answer += name.length() - r + l;
                    System.out.print(answer);
                    break;
                }else{
                    answer += r-l;
                    l = r;
                }
            }
        }

        if(q.isEmpty() && r != name.length()-1){
            answer += r-l;
        }

        System.out.print(answer);

        for(int i = 0; i < name.length(); i++){
            if(name.charAt(i) <= 'N'){
                for(char c = 'A'; c <= 'N'; c++){
                    if(name.charAt(i) == c){
                        break;
                    }
                    answer++;
                }
            }else{
                answer++;
                for(char c = 'Z'; c >= 'N'; c--){
                    if(name.charAt(i) == c){
                        break;
                    }
                    answer++;
                }
            }
        }
        return answer;
    }
}