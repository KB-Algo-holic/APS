import java.io.*;
import java.util.*;

// SWEA - 5174 subtree
// 트리
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWTay1Z64cQDFAVT
// 자바제출이 안돼요
public class SWEA_5174_YHS {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());

        int T = Integer.parseInt(tokens.nextToken());

        for(int t=1; t<=T; t++){
            output.append("#"+t+" ");
            tokens = new StringTokenizer(input.readLine());
            int E = Integer.parseInt(tokens.nextToken());
            int N = Integer.parseInt(tokens.nextToken());
            tokens = new StringTokenizer(input.readLine());

            List<Node> list = new ArrayList<>();

            int max = 0;
            for(int e=0; e<E; e++){
                int from = Integer.parseInt(tokens.nextToken());
                int to   = Integer.parseInt(tokens.nextToken());

                if(max < Integer.max(from, to)){
                    max = Integer.max(from, to);
                }

                list.add(new Node(from, to));
            }
            List[] graph = new List[max+1];
            for(int i=0; i<max+1; i++){
                graph[i] = new ArrayList<Integer>();
            }

            for(int i=0; i<list.size(); i++){
                graph[list.get(i).from].add(list.get(i).to);
            }

            int sum = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(N);

            while(!queue.isEmpty()){
                int front = queue.poll();
                sum++;

                List<Integer> childs = graph[front];
                for(int i=0; i<childs.size(); i++){
                    int child = childs.get(i);
                    queue.offer(child);
                }
            }
            output.append(sum+"\n");
        }

        output.close();
    }

    static class Node{
        int from;
        int to;

        public Node(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    static String src = "3\n" +
            "5 1\n" +
            "2 1 2 5 1 6 5 3 6 4\n" +
            "5 1\n" +
            "2 6 6 4 6 5 4 1 5 3\n" +
            "10 5\n" +
            "7 6 7 4 6 9 4 11 9 5 11 8 5 3 5 2 8 1 8 10";
}