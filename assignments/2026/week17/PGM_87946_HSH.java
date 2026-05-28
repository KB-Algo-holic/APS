public class PGM_87946_HSH {
    public static void main(String[] args) {
        PGM_87946_HSH solution = new PGM_87946_HSH();
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        int result = solution.solution(k, dungeons);
        System.out.println(result); // Output: 3
    }

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        // 던전을 갔는지 안갔는지 체크하기 위함 
        boolean[] visited = new boolean[dungeons.length];
        answer = dfs(k, dungeons, visited, 0);
        return answer;
    }
    /***
    1) 최소 필요 피로도로 던전 방문할 수 있는지를 체크해야함 (dungeons[i][0])
    2) 던전 돌면 소모 피로도만큼 빼줘야함 -> k - dungeons[i][1]
    3) 단, 한 번 방문한 곳은 다시 방문할 수 없도록 조치해두고 백트레킹으로 방문을 번복하는 로직을 넣음
    4) 다음 던전을 돌 때에는 카운트를 늘려서 진행하고, 던전에 대해서 dfs를 돌도록 해두었으니 
    k값은 소모피로도 뺀 값이고 나머지 내용은 동일 -> 카운트만 하나 증가할 것
    5) 최대로 던전을 돌아야 하는 것이므로 카운트가 max일 때로 정리 -> 리턴값 
    ***/
    private int dfs(int k, int[][] maps, boolean[] visited, int count) {
        int maxCount = count;
        for(int i=0;i<maps.length;i++){
            if(!visited[i] && k >= maps[i][0]) {
                visited[i] = true;
                maxCount = Math.max(maxCount, dfs(k - maps[i][1], maps, visited, count + 1));
                visited[i] = false; // 백트레킹 (던전 방문 여부 초기화)
            }
        }
        
        return maxCount;
    }
}
