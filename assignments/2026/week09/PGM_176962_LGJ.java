// PGM - 176962 과제진행하기
// 구현 Stack
// https://school.programmers.co.kr/learn/courses/30/lessons/176962


import java.util.*;

class Solution {
    public static String[] solution(String[][] plans) {

        List<String> list = new ArrayList<>();

        for (String[] plan: plans) {
            String[] times = plan[1].split(":");
            plan[1] = String.valueOf(
                    Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1])
            );
        }

        Arrays.sort(plans, (a, b) ->
                Integer.parseInt(a[1]) - Integer.parseInt(b[1])
        );

        Stack<String[]> stack = new Stack<>();

        for (String[] plan: plans) {

            int startTime = Integer.parseInt(plan[1]);

            if (stack.isEmpty()) {
                stack.push(plan);
            } else {

                int currentTime = Integer.parseInt(stack.peek()[1]);

                while (!stack.isEmpty()) {

                    String[] last = stack.pop();

                    int remain = Integer.parseInt(last[2]);

                    if (currentTime + remain <= startTime) {

                        currentTime += remain;
                        list.add(last[0]);

                    } else {

                        last[2] = String.valueOf(remain - (startTime - currentTime));
                        stack.push(last);
                        break;
                    }
                }

                stack.push(plan);
            }
        }

        while (!stack.isEmpty()) {
            list.add(stack.pop()[0]);
        }

        return list.toArray(new String[list.size()]);
    }

}
