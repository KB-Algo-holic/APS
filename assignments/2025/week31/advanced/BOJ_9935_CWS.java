// PGM 9935 - 문자열 폭발
// 유형: 스택
// 링크: https://www.acmicpc.net/problem/9935

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> dq = new LinkedList<>();

        String s1 = br.readLine(); // 원본 문자열
        String s2 = br.readLine(); // 폭발 문자열

        // 원본 문자열 순회
        for(int i = 0; i < s1.length(); i++){
            dq.offer(s1.charAt(i));

            // 마지막 문자가 폭발 문자열의 마지막 문자와 같을 때만 검사
            if(dq.peekLast() == s2.charAt(s2.length() - 1)){
                // 길이가 충분할 때만 폭발
                if(dq.size() >= s2.length()){
                    // 비교 중 꺼낸 문자 임시 저장
                    Deque<Character> tempDq = new LinkedList<>();
                    // 뒤에서부터 폭발 문자열과 비교
                    for(int j = s2.length() - 1; j >= 0; j--){
                        if(s2.charAt(j) == dq.peekLast()){
                            tempDq.offer(dq.pollLast());
                        }else{
                            // 하나라도 다르면 원상 복구
                            while(!tempDq.isEmpty()){
                                dq.offer(tempDq.pollLast());
                            }
                            break;
                        }
                    }
                }
            }
        }

        // 결과 출력
        if(dq.isEmpty()){
            System.out.println("FRULA");
        }else{
            StringBuilder sb = new StringBuilder();
            while(!dq.isEmpty()){
                sb.append(dq.pollFirst());
            }
            System.out.println(sb.toString());
        }
    }
}
