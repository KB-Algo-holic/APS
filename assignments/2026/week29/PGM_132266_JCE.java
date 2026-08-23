/*
 * 요구사항 : 임무를 수행한 각 부대원이 지도 정보를 이용해 부대로 복귀할 수 있는 최단시간을 담은 배열을 구해라
 * 제약 : 적군의 방해로 인해 임무의 시작 때와 다르게 되돌아오는 경로가 없어져 복귀 불가능한 경우엔 -1 반환
 *
 */

public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
    int[] answer = new int[sources.length];

    // 1. 노드별 각 경로 인접 리스트 생성(무방향)
    List<Integer>[] graph = new List[n + 1];

    for (int i = 0; i <= n; i++) {
        graph[i] = new ArrayList<>();
    }

    for (int[] road : roads) {
        int a = road[0];
        int b = road[1];
        graph[a].add(b);
        graph[b].add(a);
    }

    // 2. BFS - destination 에서 전체 노드로의 최단거리(dist) 계산
    boolean[] visited = new boolean[n + 1];
    int[] dist = new int[n + 1];
    int cnt = 0;
    visited[destination] = true;
    dist[destination] = cnt;
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < graph[destination].size(); i++) {
        queue.offer(new int[] {graph[destination].get(i), cnt + 1});
    }

    while (!queue.isEmpty()) {
        int[] temp = queue.poll();
        if (visited[temp[0]]) continue;

        for (int i = 0; i < graph[temp[0]].size(); i++) {
            queue.offer(new int[] {graph[temp[0]].get(i), temp[1] + 1});
        }

        visited[temp[0]] = true;
        dist[temp[0]] = temp[1];
    }

    for (int i = 1; i < visited.length; i++) {
        if (!visited[i]) dist[i] = -1;
    }

    for (int i = 0; i < sources.length; i++) {
        answer[i] = dist[sources[i]];
    }

    return answer;
}

