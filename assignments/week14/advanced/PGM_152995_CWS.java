// PGM 152995 - 인사고과
// 유형: 시뮬레이션
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/152995

import java.util.*;

class Solution {
    public int solution(int[][] scores) {

        Integer[] sum = new Integer[scores.length];
        int answerX = scores[0][0];
        int answerY = scores[0][1];
        int answerSum = 0;
        int answer = -1;

        Arrays.fill(sum, -1);

        //2차원 배열 내림차순 정렬
        Arrays.sort(scores, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] != b[0]){
                    return Integer.compare(b[0], a[0]);
                }else{
                    return Integer.compare(b[1], a[1]);
                }
            }
        });

        // 기본 사원 점수 저장
        int X = scores[0][0];
        int Y = scores[0][1];
        sum[0] = scores[0][0] + scores[0][1];

        for(int i = 1; i < scores.length; i++){
            if(X > scores[i][0]){ //이전 사람보다 낮은 경우
                if(Y > scores[i][1]){
                    scores[i][0] = -1;
                    scores[i][1] = 0;
                }else if(Y < scores[i][1]){ //점수가 높은경우
                    X = scores[i][0];
                    Y = scores[i][1];
                }
            }else if(X == scores[i][0]){ //점수가 같은 경우
                for(int j = 0; j < i; j++){
                    if(scores[i][0] == scores[j][0])
                        break;
                    //앞사람과 비교해서 탈락여부 판단
                    if(scores[i][0] < scores[j][0]){
                        if(scores[i][1] < scores [j][1]){
                            scores[i][0] = -1; //탈락 처리
                            scores[i][1] = 0;
                            break;
                        }
                    }
                }
            }

            sum[i] = scores[i][0] + scores[i][1];
        }

        for(int i = 0; i < scores.length; i++){
            if(answerX == scores[i][0] && answerY == scores[i][1]){
                answerSum = scores[i][0] + scores[i][1];
                break;
            }
        }
        //점수합 정렬
        Arrays.sort(sum, Collections.reverseOrder());
        //순위 계산
        if(answerSum != -1){
            for(int i = 0; i < sum.length; i++){
                if(answerSum == sum[i]){
                    answer = i+1;
                    break;
                }
            }
        }

        return answer;
    }
}