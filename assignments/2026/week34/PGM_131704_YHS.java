// PGM - 131704 택배상자
// 스택
// https://school.programmers.co.kr/learn/courses/30/lessons/131704
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PGM_131704_YHS {
    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> subContainer = new Stack<>();
        Queue<Integer> mainContainer = new LinkedList<>();


        for(int i=0; i<order.length; i++){
            mainContainer.offer(i+1);
        }
        for(int i=0; i<order.length; i++){
            if(!subContainer.isEmpty() && subContainer.peek() == order[i]){
                subContainer.pop();
                answer++;
                continue;
            }
            if(!mainContainer.isEmpty() && mainContainer.peek() == order[i]){
                mainContainer.poll();
                answer++;
                continue;
            }
            boolean flag = false;
            while(!mainContainer.isEmpty() && order[i] > mainContainer.peek()){
                subContainer.push(mainContainer.poll());
                flag = true;
            }
            if(flag) {
                mainContainer.poll();
                answer++;
            }else{
                break;
            }
        }
        return answer;
    }
}
