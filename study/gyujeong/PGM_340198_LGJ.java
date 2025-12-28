import java.util.*;

public class PGM_340198_LGJ {

    class Solution {
        public int solution(int[] mats, String[][] park) {
            int answer = -1;
            int r = park.length;
            int c = park[0].length;
            Arrays.sort(mats);

            for (int m=mats.length-1; m>=0; m--) { //10
                int mat = mats[m];
                //System.out.println(mat);
                for (int i=0; i<r; i++) { //50
                    for (int j=0; j<c; j++) { //50
                        if (park[i][j].equals("-1")) {
                            boolean isPossible = true;
                            for (int a = 0; a < mat; a++) {
                                for (int b = 0; b < mat; b++) {
                                    int nr = i + a;
                                    int nc = j + b;
                                    if (nr >= r || nc >= c || !park[nr][nc].equals("-1")) {
                                        isPossible = false;
                                        break;
                                    }
                                }
                            }
                            if (isPossible) return mat;
                        }

                    }
                }
            }


            return answer;
        }
    }
}
