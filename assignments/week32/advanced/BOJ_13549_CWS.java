// BOJ 13549 - 숨바꼭질 3
// 유형: BFS
// 링크: https://www.acmicpc.net/problem/13549

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] arr;

    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[100001];
        q = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken()); // 시작
        int K = Integer.parseInt(st.nextToken()); // 끝
        //최소 시간 초기화
        Arrays.fill(arr, -1);
        // 시작점
        q.offer(N);

        // 0 부터 처리
        mul(0);

        System.out.println(arr[K]);
    }

    // x → 2x
    public static void mul(int cnt){
        int l = q.size();

        for(int i = 0; i < l; i++){
            int n = q.poll();

            while(n < 100001){
                if(n > 100000) break;

                // 아직 방문하지 않았거나 더 빠른 시간이라면 갱신
                if(arr[n] == -1 || arr[n] >= cnt){
                    q.offer(n);
                    arr[n] = cnt;
                }

                // 0은 더 이상 순간이동 의미 없음
                if(n == 0) break;

                n *= 2;
            }
        }

        // 순간이동이 끝났으면 +1, -1 이동 처리
        if(!q.isEmpty()) plus(cnt + 1);
    }

    // x+1, x-1
    public static void plus(int cnt){
        int l = q.size();

        for(int i = 0; i < l; i++){
            int n = q.poll();

            // x + 1 이동
            if(n + 1 < 100001){
                if(arr[n + 1] == -1 || arr[n + 1] >= cnt){
                    q.offer(n + 1);
                    arr[n + 1] = cnt;
                }
            }

            // x - 1 이동
            if(n - 1 >= 0){
                if(arr[n - 1] == -1 || arr[n - 1] >= cnt){
                    q.offer(n - 1);
                    arr[n - 1] = cnt;
                }
            }
        }

        // 다시 순간이동 처리
        if(!q.isEmpty())
            mul(cnt);
    }
}
