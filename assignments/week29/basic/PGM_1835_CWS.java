// PGM 1835 - 단체사진찍기
// 유형: 완전탐색
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/1835
import java.util.*;

class Solution {

    static char[] chara = {'A','C','F','J','M','N','R','T'};
    static char[] list;
    static boolean[] isSelected;
    static int N, answer;
    static String[] DATA;

    public int solution(int n, String[] data) {
        DATA = data;
        N = n;

        list = new char[8];
        isSelected = new boolean[8];
        answer = 0;
        permu(0);

        return answer;
    }

    // 순열 생성
    public static void permu(int cnt){

        if(cnt == 8){
            // 모든 조건 검사
            for(int i = 0; i < N; i++){
                int n1 = 0, n2 = 0;

                // 위치 찾기
                for(int j = 0; j < 8; j++){
                    if(DATA[i].charAt(0) == list[j]) n1 = j;
                    if(DATA[i].charAt(2) == list[j]) n2 = j;
                }

                // 실제 거리
                int dist = Math.abs(n1 - n2) - 1;

                char op = DATA[i].charAt(3);
                int val = DATA[i].charAt(4) - '0';

                // 조건 비교
                if(op == '='){
                    if(dist != val) return;
                }else if(op == '>'){
                    if(dist <= val) return;
                }else{
                    if(dist >= val) return;
                }
            }

            // 모든 조건을 만족시 경우의 수 증가
            answer++;
            return;
        }

        // 순열 생성
        for(int i = 0; i < 8; i++){
            if(isSelected[i]) continue;

            list[cnt] = chara[i];
            isSelected[i] = true;
            permu(cnt + 1);
            isSelected[i] = false;
        }
    }
}
