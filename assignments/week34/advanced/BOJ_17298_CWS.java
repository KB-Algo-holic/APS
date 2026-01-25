// BOJ 17298 - 오큰수
// 유형: 스택
// 링크: https://www.acmicpc.net/problem/17298

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        // 값과 인덱스를 각각 저장
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            while(true){
                // 스택이 비어 있으면 그냥 push
                if(stack1.isEmpty()){
                    stack1.push(num);
                    stack2.push(i);
                    break;

                    // 현재 값이 스택 top보다 크면
                }else if(stack1.peek() < num) {
                    stack1.pop();
                    arr[stack2.pop()] = num;

                    // 현재 값이 더 작거나 같으면
                }else{
                    stack1.push(num);
                    stack2.push(i);
                    break;
                }
            }
        }

        // 끝까지 못 찾은 값 → -1
        for (int i = 0; i < N; i++) {
            if(arr[i] == 0){
                arr[i] = -1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < N; j++) {
            sb.append(arr[j]).append(' ');
        }
        System.out.println(sb);
    }
}
