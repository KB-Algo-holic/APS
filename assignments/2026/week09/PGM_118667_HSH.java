package week09;

import java.util.LinkedList;
import java.util.Queue;

public class PGM_118667_HSH {
    public static void main(String[] args) {
        PGM_118667_HSH sol = new PGM_118667_HSH();
        int queue1[] = {
                3, 2, 7, 2
        };
        int queue2[] = {
                4, 6, 5, 1
        };
        int answer = PGM_118667_HSH.solution(queue1, queue2);
        System.out.println(answer);
    }  

    public static int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        for(int elem : queue1) {
            q1.add(elem);
            sum1 += elem;
        }
        for(int elem : queue2) {
            q2.add(elem);
            sum2 += elem;
        }

        int maxCount = (queue1.length + queue2.length) * 2; // 최대 이동 횟수
        int count = 0;

        while(count < maxCount) {
            if(sum1 == sum2) {
                answer = count;
                break;
            } else if(sum1 > sum2) {
                int temp = q1.poll();
                sum1 -= temp;
                q2.add(temp);
                sum2 += temp;
            } else {
                int temp = q2.poll();
                sum2 -= temp;
                q1.add(temp);
                sum1 += temp;
            }
            count++;
        }

        return answer;
    }
}
