import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] takes;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] costs = new int[n+1][n+1];
        int[][] mid = new int[n+1][n+1];

        for(int i=1; i<=n; i++) Arrays.fill(costs[i], Integer.MAX_VALUE);

        for(int i=1; i<=n; i++) costs[i][i] = 0;

        for(int i=0; i<m; i++) {
            String[] line = br.readLine().split(" ");
            int from = Integer.parseInt(line[0]);
            int to = Integer.parseInt(line[1]);
            int cost = Integer.parseInt(line[2]);

            if(costs[from][to]==Integer.MAX_VALUE)
                costs[from][to] = cost;
            else if(costs[from][to]>cost) costs[from][to] = cost;

            mid[from][to] = from;
        }

        for(int i=1; i<=n; i++)
            for(int j=1; j<=n; j++) {
                if(costs[i][j]!=Integer.MAX_VALUE)
                    for(int k=1; k<=n; k++)
                        if(costs[k][i]!=Integer.MAX_VALUE&&costs[k][j] > costs[k][i] + costs[i][j]) {
                            mid[k][j] = i;
                            costs[k][j] = costs[k][i] + costs[i][j];
                        }
            }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(costs[i][j]==Integer.MAX_VALUE) sb.append(0).append(" ");
                else sb.append(costs[i][j]).append(" ");
            }
            sb.append(System.lineSeparator());
        }

        System.out.print(sb);

    }
}