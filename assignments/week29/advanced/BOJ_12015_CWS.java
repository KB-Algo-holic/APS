// BOJ 12015 - 가장 긴 증가하는 부분 수열 2
// 유형: 이분탐색
// 링크: https://www.acmicpc.net/problem/12015

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();

        // 첫 값 입력
        list.add(Integer.parseInt(st.nextToken()));

        for(int i = 1; i < N; i++){
            int num = Integer.parseInt(st.nextToken());

            // 가장 큰 값보다 크면 그대로 추가
            if(num > list.get(list.size() - 1)){
                list.add(num);
            }else{
                int l = 0;
                int r = list.size() - 1;

                while(l < r){
                    int m = (l + r) / 2;
                    if(list.get(m) < num){
                        l = m + 1;
                    }else{
                        r = m;
                    }
                }
                // 해당 위치 값 교체
                list.set(l, num);
            }
        }

        System.out.println(list.size());
    }
}
