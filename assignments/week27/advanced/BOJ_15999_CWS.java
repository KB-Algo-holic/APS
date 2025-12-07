// BOJ 15999 - 뒤집기
// 유형: DP
// 링크: https://www.acmicpc.net/problem/15999

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 1;

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        char[][] map = new char[m][n];

        // 지도 입력
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j = 0; j < n; j++){
                map[i][j] = s.charAt(j);
            }
        }

        // 모든 칸 탐색
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                boolean t = true;

                // 4방향 비교
                for(int k = 0; k < 4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    // 지도 범위 안이라면 체크
                    if(nx >= 0 && ny >= 0 && nx < m && ny < n){
                        // 주변 칸 중 하나라도 다르면 false
                        if(map[i][j] != map[nx][ny]){
                            t = false;
                            break;
                        }
                    }
                }

                // 주변 모든 칸이 같으면 경우의 수 * 2
                if(t){
                    answer = answer * 2 % 1_000_000_007;
                }
            }
        }

        System.out.println(answer);
    }
}
