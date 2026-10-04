// PGM - 87946 피로도
// 순열
// https://school.programmers.co.kr/learn/courses/30/lessons/87946
public class PGM_87946_YHS {
    boolean isSelected[];
    int result[], answer, K, arr[][];
    public int solution(int k, int[][] dungeons) {
        arr = new int[dungeons.length][2];
        for(int i=0; i<dungeons.length; i++){
            arr[i] = dungeons[i].clone();
        }
        isSelected = new boolean[dungeons.length];
        result = new int[dungeons.length];
        K = k;
        for(int i=0; i<dungeons.length; i++){
            result[i] = i+1;
        }
        permutation(0);
        return answer;
    }

    private void permutation(int cnt) {
        if(cnt == result.length){
            answer = Math.max(answer, getCount(answer));
            return;
        }
        for(int i=0; i<result.length; i++){
            if(isSelected[i]) continue;
            result[cnt] = i;
            isSelected[i] = true;
            permutation(cnt+1);
            isSelected[i] = false;
        }
    }

    private int getCount(int answer) {
        int piro = K;
        int cnt = 0;
        for(int i=0; i<result.length; i++){
            if(piro >= arr[result[i]][0]){
                cnt++;
                piro -= arr[result[i]][1];
            }else{
                break;
            }
        }
        return cnt;
    }
}
