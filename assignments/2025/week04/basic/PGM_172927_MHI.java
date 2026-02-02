class Solution {
    static int answer = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {

        makeAns(picks, minerals, 0, 0);

        return answer;
    }

    public void makeAns(int[] picks, String[] minerals, int i, int stress) {
        if (picks[0] == 0 && picks[1] == 0 && picks[2] == 0) {
            answer = Math.min(answer, stress);
        } else if (i >= minerals.length) {
            answer = Math.min(answer, stress);
        } else {
            for (int j=0; j<3; j++) {
                if (picks[j] == 0) continue;
                picks[j] --;
                int sum = 0;
                for (int k=0; k<5; k++) {
                    if (i + k < minerals.length) {
                        if (minerals[i + k].equals("diamond")) {
                            if (j == 2) sum += 25;
                            else if (j == 1) sum += 5;
                            else sum ++;
                        } else if (minerals[i + k].equals("iron")) {
                            if (j == 2) sum += 5;
                            else sum ++;
                        } else {
                            sum ++;
                        }
                    }
                }
                makeAns(picks, minerals, i + 5, stress + sum);
                picks[j] ++;
            }
        }
    }
}