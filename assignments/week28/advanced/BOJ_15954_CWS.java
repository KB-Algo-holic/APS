import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double answer = Integer.MAX_VALUE;

        int N = Integer.parseInt(st.nextToken()); // 인형 개수
        int K = Integer.parseInt(st.nextToken()); // 최소 구간 길이

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 구간 길이를 K부터 N까지 증가
        while(K <= N){

            // 시작 인덱스
            for(int i = 0; i < N - K + 1; i++){

                double m = 0; // 평균
                double v = 0; // 분산

                // 평균 계산
                for(int j = i; j < i + K; j++){
                    m += arr[j];
                }
                m /= K;

                // 분산 계산
                for(int j = i; j < i + K; j++){
                    v += Math.pow(arr[j] - m, 2);
                }

                // 표준편차 최소값 갱신
                answer = Math.min(Math.sqrt(v / K), answer);
            }

            // 구간 길이 증가
            K++;
        }

        System.out.println(answer);
    }
}
