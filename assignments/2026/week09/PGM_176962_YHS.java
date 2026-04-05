// PGM - 176962 과제 진행하기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/176962

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class PGM_176962_YHS {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];

        ArrayList<Node> list = new ArrayList<>();
        for(int i=0; i<plans.length; i++){
            String name = plans[i][0];
            int start = Integer.parseInt(plans[i][1].substring(0,2)) * 60 + Integer.parseInt(plans[i][1].substring(3));
            int playtime = Integer.parseInt(plans[i][2]);

            list.add(new Node(name, start, playtime));
        }

        Collections.sort(list, new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2){
                return Integer.compare(o1.start, o2.start);
            }
        });

        Stack<Node> stack = new Stack<>();
        int cur = 0;
        int remain = 0;
        int cnt = 0;

        for(int i=0; i<list.size(); i++){
            cur = list.get(i).start;
            if(stack.isEmpty()){
                stack.push(list.get(i));
            }else{
                remain = cur - stack.peek().start;

                // stack에 쌓인 과제 처리
                while(!stack.isEmpty() && remain > 0){
                    Node peek = stack.pop();
                    if(remain >= peek.playtime){
                        answer[cnt++] = peek.name;
                        remain -= peek.playtime;
                    }else{
                        peek.playtime = peek.playtime - remain;
                        stack.push(peek);
                        remain = 0;
                    }
                }
                stack.push(list.get(i));
            }
        }
        while(!stack.isEmpty()){
            answer[cnt++] = stack.pop().name;
        }


        return answer;
    }

    class Node{
        String name;
        int start;
        int playtime;

        public Node(String name, int start, int playtime){
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }
}
