// PGM -  숫자블록
// 그리디? 구현? - 숫자블록
// https://school.programmers.co.kr/learn/courses/30/lessons/12923


class Solution {
    public int[] solution(long begin, long end) {
        int n = Long.valueOf(end - begin).intValue();
        int[] answer = new int[n+1];

        for (long i=end; i>=begin; i--) { //max 5000
            long num = i;
            int biggest = 0;
            //System.out.println("num :" + Long.toString(num));
            for (long j=2; j<=Math.sqrt(num); j++) {
                //System.out.println("j : " + Long.toString(j));
                if (num % j == 0) {
                    //System.out.println("success :" + Long.toString(num/j));
                    if (num/j > 10000000) {
                        biggest = Long.valueOf(j).intValue();
                        continue;
                    }
                    biggest = Long.valueOf(num/j).intValue();
                    break;
                }
            }
            if (num != 1 && biggest == 0) {
                answer[n] = 1;
            } else {
                answer[n] = biggest;
            }
            n --;
        }

        return answer;
    }
}