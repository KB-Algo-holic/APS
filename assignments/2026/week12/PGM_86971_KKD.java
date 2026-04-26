import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    static boolean[] visit;
    
    public int solution(int n, int[][] wires) {
        
        int answer = 1000;
		ArrayList<Integer>[] adj = new ArrayList[n+1];
		
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		
		for (int i = 0; i < wires.length; i++)
		{
			adj[wires[i][0]].add(wires[i][1]);
			adj[wires[i][1]].add(wires[i][0]);
		}
		
		for(int skip=0;skip<wires.length;skip++)
		{
			int skip1 = wires[skip][0];
			int skip2 = wires[skip][1];
			
			
			visit = new boolean[n+1];
			visit[1] = true;
			dfs(skip1,skip2,adj,1);
			
			int tcount = 0;
			int fcount = 0;
			for(int i=1;i<=n;i++)
			{
				if(visit[i])
					tcount++;
				else
					fcount++;
			}
			
			int temp = Math.abs(tcount-fcount);
			answer = Math.min(answer, temp);
		//	System.out.println(Arrays.toString(visit));
		}
		
//		for (int i = 0; i < list.size(); i++) {
//			
//			System.out.println(Arrays.toString(list.get(i)));
//		}

        return answer;
    }
    	private static void dfs(int skip1, int skip2, ArrayList<Integer>[] adj,int idx) {
		
		for(int i=0;i<adj[idx].size();i++)
		{
			if(skip1 == idx && skip2 == adj[idx].get(i))
				continue;
			if(skip2 == idx && skip1 == adj[idx].get(i))
				continue;
			
			if(!visit[adj[idx].get(i)])
			{
				visit[adj[idx].get(i)] = true;
				dfs(skip1,skip2,adj,adj[idx].get(i));
			}
		}
		
	}
}
