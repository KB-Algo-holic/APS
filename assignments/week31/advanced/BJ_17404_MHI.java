import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] house;
    static int[][] dp;
    static int n;
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        house = new int[n+1][3];

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            house[i][0] = Integer.parseInt(st.nextToken());
            house[i][1] = Integer.parseInt(st.nextToken());
            house[i][2] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0; i<3; i++) {
            dp = new int[n+1][3];
            answer = Math.min(answer, makeAnswer(i, 1, i));
        }

        System.out.print(answer);
    }

    static int makeAnswer(int firstC, int nowN, int nowC) {

        if(nowN==n)
            if(firstC==nowC) return 1000;
            else return house[nowN][nowC];

        if(dp[nowN][nowC]>0) return dp[nowN][nowC];

        if(nowC==0)
            return dp[nowN][nowC]=house[nowN][nowC] + Math.min(makeAnswer(firstC, nowN+1, 1), makeAnswer(firstC, nowN+1, 2));
        else if(nowC==1)
            return dp[nowN][nowC]=house[nowN][nowC] + Math.min(makeAnswer(firstC, nowN+1, 0), makeAnswer(firstC, nowN+1, 2));

        return dp[nowN][nowC]=house[nowN][nowC] + Math.min(makeAnswer(firstC, nowN+1, 0), makeAnswer(firstC, nowN+1, 1));
    }

}