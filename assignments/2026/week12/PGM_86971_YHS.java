import java.util.ArrayList;
import java.util.List;

// PGM - 86971 L2_전력망을둘로나누기
// 완전탐색
// https://school.programmers.co.kr/learn/courses/30/lessons/86971
public class PGM_86971_YHS {
    List[] graph;
    boolean[] isVisited;
    int[] cnt;
    int N, answer=Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {
        answer = Integer.MAX_VALUE;
        N = n;

        graph = new List[n+1];
        isVisited = new boolean[n+1];
        cnt = new int[n+1];

        for(int i=0; i<n+1; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<wires.length; i++){
            int from = wires[i][0];
            int to = wires[i][1];

            graph[from].add(to);
            graph[to].add(from);
        }

        isVisited[1] = true;
        dfs(1);

        return answer;
    }

    private int dfs(int cur){
        // System.out.println(cur);
        List<Integer> childs = graph[cur];

        int sum = 1;
        for(int i=0; i<childs.size(); i++){
            int child = childs.get(i);
            if(!isVisited[child]){
                isVisited[child] = true;
                sum += dfs(child);
            }
        }

        if(answer > Math.abs(N-sum - sum)){
            answer = Math.abs(N-sum - sum);
        }
        // System.out.println(cur+" : "+sum+" ==> "+Math.abs(N-sum - sum));
        return sum;
    }
}