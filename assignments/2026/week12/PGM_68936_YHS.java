import java.util.Arrays;

// PGM - 68936 L2_쿼드압축 후 개수 세기
// 트리
// https://school.programmers.co.kr/learn/courses/30/lessons/68936
public class PGM_68936_YHS {
    int z, o;
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];

        int N = arr.length;

        /*
        1. 2차원 배열을 탐색 search(arr, r, c, size);
        2. size가 1이면 리턴
        3-1. 0이든 1이든 같은값이 나오면 PASS
        3-2. 다른값이 나오면 search()를 4개 쪼개서 ㄱㄱ
       */
        search(arr, 0, 0, N);
        answer[0] = z;
        answer[1] = o;
        return answer;
    }

    void search(int[][] arr, int sr, int sc, int size){
        int first = arr[sr][sc];
        if(size == 1){
            // System.out.println(sr+" "+sc+" "+size);
            if(first == 0){
                z++;
            }else{
                o++;
            }
            return;
        }
        int sum = 0;
        boolean flag = true;
        outer : for(int r=sr; r<sr+size; r++){
            for(int c=sc; c<sc+size; c++){
                if(arr[r][c] != first){
                    flag = false;
                    break;
                }
            }
        }

        if(flag){
            if(first == 0){
                z++;
            }else{
                o++;
            }
        }else{
            search(arr, sr, sc, size/2);
            search(arr, sr+size/2, sc, size/2);
            search(arr, sr, sc+size/2, size/2);
            search(arr, sr+size/2, sc+size/2, size/2);
        }
    }
}
