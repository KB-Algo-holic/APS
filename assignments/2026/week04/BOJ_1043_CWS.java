// PGM 1043 - 거짓말
// 시뮬레이션
// https://www.acmicpc.net/problem/1043

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int M = Integer.parseInt(st.nextToken()); // 파티 수

        st = new StringTokenizer(br.readLine());
        HashSet<Integer> hs = new HashSet<>();
        HashMap<Integer, List<Integer>> hm = new HashMap<>();

        int n = Integer.parseInt(st.nextToken()); // 진실을 아는 사람 수
        for(int i = 0; i < n; i++) {
            hs.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < k; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            hm.put(i, list);
        }

        // 진실 전파 과정
        while(true) {
            int t = hs.size();
            for(int i = 0; i < hm.size(); i++) {
                for(int j = 0; j < hm.get(i).size(); j++) {
                    if(hs.contains(hm.get(i).get(j))) {
                        for(int k = 0; k < hm.get(i).size(); k++) {
                            hs.add(hm.get(i).get(k));
                        }
                        break;
                    }
                }
            }
            if(t == hs.size()) break;
        }

        int answer = M;
        for(int i = 0; i < hm.size(); i++) {
            for(int j = 0; j < hm.get(i).size(); j++) {
                if(hs.contains(hm.get(i).get(j))) {
                    answer--;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
