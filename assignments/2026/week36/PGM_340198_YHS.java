// PGM - 340198 공원
// 스택
// https://school.programmers.co.kr/learn/courses/30/lessons/340198
import java.util.Arrays;

public class PGM_340198_YHS {
    int R, C;
    public int solution(int[] mats, String[][] park) {
        int answer = -1;

        R = park.length;
        C = park[0].length;

        Arrays.sort(mats);
        int size = mats.length;

        zz : for(int i=size-1; i>=0; i--){
            for(int r=0; r<R; r++){
                for(int c=0; c<C; c++){
                    if(park[r][c].equals("-1")){
                        if(isOk(park, r, c, mats[i])){
                            answer = mats[i];
                            break zz;
                        }
                    }
                }
            }
        }

        return answer;
    }

    boolean isOk(String[][] park, int sr, int sc, int size){
        boolean result = true;

        for(int r=sr; r<sr+size; r++){
            for(int c=sc; c<sc+size; c++){
                if(!isIn(r, c)) {
                    return false;
                }

                if(!park[r][c].equals("-1")){
                    return false;
                }
            }
        }

        return result;
    }

    boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<R && c<C);
    }
}
