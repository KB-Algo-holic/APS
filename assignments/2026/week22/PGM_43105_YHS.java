// PGM - 43105 L3_멀리뛰기
// DP
// https://school.programmers.co.kr/learn/courses/30/lessons/43105?language=java
public class PGM_43105_YHS {
    public int solution(int[][] triangle) {
        int answer = 0;
        int size = triangle.length;
        int max[][] = new int[size][size];
        max[0][0] = triangle[0][0];

        for(int r=0; r<size-1; r++){
            for(int c=0; c<r+1; c++){
                max[r+1][c] = Math.max(max[r+1][c], max[r][c]+triangle[r+1][c]);
                max[r+1][c+1] = Math.max(max[r+1][c+1], max[r][c]+triangle[r+1][c+1]);
            }
        }

        // for(int x[] : max){
        //     System.out.println(Arrays.toString(x));
        // }

        for(int c=0; c<size; c++){
            if(answer < max[size-1][c]){
                answer = max[size-1][c];
            }
        }

        return answer;
    }
}
