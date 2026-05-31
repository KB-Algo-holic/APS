// PGM - 86491 L1_최소직사각형
// 완전탐색
// https://school.programmers.co.kr/learn/courses/30/lessons/86491?language=java
public class PGM_86491_YHS {
    public int solution(int[][] sizes) {
        int answer = 0;

        int maxW = 0;
        int maxH = 0;

        for(int i=0; i<sizes.length; i++){
            int a = sizes[i][0];
            int b = sizes[i][1];

            if(a < b){
                maxW = Math.max(a, maxW);
                maxH = Math.max(b, maxH);
            }else{
                maxW = Math.max(b, maxW);
                maxH = Math.max(a, maxH);
            }
        }

        answer = maxW * maxH;

        return answer;
    }
}
