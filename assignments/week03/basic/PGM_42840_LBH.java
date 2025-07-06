// PGM 42840 - 모의고사
// 유형: 완전탐색
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42840
class Solution {
    public int[] solution(int[] answers) {

        int[][] supozas = new int[3][];
        supozas[0] = new int[]{1,2,3,4,5};
        supozas[1] = new int[]{2,1,2,3,2,4,2,5};
        supozas[2] = new int[]{3,3,1,1,2,2,4,4,5,5};

        int[] corrects = new int[]{0,0,0};

        for(int i = 0; i < answers.length; i++){
            for(int j = 0; j < 3; j++){
                if(answers[i] == supozas[j][i % supozas[j].length]){
                    corrects[j]++;
                }
            }
        }

        int max = Math.max(corrects[0], Math.max(corrects[1], corrects[2]));

        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (corrects[i] == max) count++;
        }

        int[] answer = new int[count];
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            if (corrects[i] == max) answer[idx++] = i + 1;
        }

        return answer;
    }
}