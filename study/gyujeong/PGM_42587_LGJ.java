public class PGM_42587_LGJ {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        int length = priorities.length;
        int first = 0;
        int last = length-1;

        while (true) {
            int max_pr = 0;
            for (int p: priorities) {
                max_pr = Math.max(max_pr, p);
            }

            if (priorities[first] >= max_pr) {
                answer ++;
                priorities[first] = 0;
                if (first == location) break;
            }

            first ++;
            if (first > last) { first = first-length; }

        }
        return answer;
    }
}
