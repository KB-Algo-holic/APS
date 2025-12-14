// BOJ 15999 - 뒤집기
// 유형: DP
// 링크: https://www.acmicpc.net/problem/15999

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double answer = Integer.MAX_VALUE;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while(K <= N){
            for(int i = 0; i < N-K+1; i++){
                double m = 0; //평균
                double v = 0; //분산
                for(int j = i; j < i+K; j++){
                    m += arr[j];
                }
                m /= K;

                for(int j = i; j < i+K; j++){
                    v += Math.pow(arr[j] - m,2);
                }
                answer = Math.min(Math.sqrt(v/K), answer);
            }
            K++;
        }
        System.out.println(answer);
    }
}
