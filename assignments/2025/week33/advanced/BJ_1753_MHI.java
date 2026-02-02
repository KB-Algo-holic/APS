import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {

    static int[] min;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line[] = br.readLine().split(" ");
        int v = Integer.parseInt(line[0]);
        int e = Integer.parseInt(line[1]);
        int start = Integer.parseInt(br.readLine());

        LinkedList<Dot>[] list = new LinkedList[v+1];
        min = new int[v+1];
        for(int i=0; i<=v; i++) {
            list[i] = new LinkedList<Dot>();
            min[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<e; i++) {
            line = br.readLine().split(" ");
            int pre = Integer.parseInt(line[0]);
            int next = Integer.parseInt(line[1]);
            int cost = Integer.parseInt(line[2]);

            list[pre].add(new Dot(next, cost));
        }

        PriorityQueue<Dot> que = new PriorityQueue<Dot>();


        que.add(new Dot(start,0));
        min[start] = 0;

        boolean[] visited = new boolean[v+1];

        while(!que.isEmpty()) {
            Dot pre = que.poll();

            if(!visited[pre.next]) {
                visited[pre.next]=true;

                Iterator<Dot> it = list[pre.next].iterator();
                while(it.hasNext()) {
                    Dot d = it.next();
                    int nextDot = d.next;
                    int nextCost = d.cost;

                    if(min[nextDot]>min[pre.next]+nextCost) {
                        min[nextDot] = min[pre.next]+nextCost;
                        que.add(d);
                        visited[d.next] = false;
                    }

                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=v; i++)
            if(min[i]==Integer.MAX_VALUE) sb.append("INF").append(System.lineSeparator());
            else sb.append(min[i]).append(System.lineSeparator());

        System.out.print(sb);
    }

    static class Dot implements Comparable<Dot>{
        int next;
        int cost;
        public Dot(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
        @Override
        public int compareTo(Dot another) {
            return min[this.next]-min[another.next];
        }
    }
}