package week15;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Node {
    int target;
    int cost;

    public Node(int target, int cost) {
        this.target = target;
        this.cost = cost;
    }
}

public class PGM_42861_HSH {
    private static boolean[] visited;
    private static List<List<Node>> graph = new ArrayList<>();
    private static PriorityQueue<Node> pq; // Node 상에서 cost가 적은걸 우선순위로 잡아서 반환할 것
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 4;
        int[][] costs = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } };

        int res = solution(n, costs);
        System.out.println(res);
    }


    /**
     * n개의 섬 사이에 다리를 건설하는 비용 -> 모든 섬이 통행 가능하도록 만들 때 필요한 최소 비용
     * 
     * @param n
     * @param costs
     * @return
     */
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        // 비용 젤 적은걸로해서 먼저 정렬을 시켜놓을 것
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>()); // 그래프를 먼저 그려놓는다. 여기에 노드 연결될 것들을 정리하기 위해 생성해둠
        }

        visited = new boolean[n]; // 현재 노드는 방문했습니다. (최저점 구했으니 다음 타겟으로 가시죠)
        // n은 노드의 갯수
        for (int i = 0; i < costs.length; i++) {
            int currentNode = costs[i][0];
            int targetNode = costs[i][1];
            int cost = costs[i][2];

            // 그래프의 기본 원칙으로 현재 노드 - 타겟 노드 & 타겟 노드 - 현재 노드 연결
            graph.get(currentNode).add(new Node(targetNode, cost));
            graph.get(targetNode).add(new Node(currentNode, cost));
        }

        pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Node(0, 0));

        int connection = 0; // 연결된 갯수가 n개 넘기지 않도록 할 것
        while (!pq.isEmpty()) {
            Node curNode = pq.poll(); // 현재 노드
            // 현재 노드가 이동할 타겟 노드에 이미 방문했다면 더 방문하지 않을 것 -> 어차피 최소값으로 우선순위큐로 셋팅했기 때문에 여러번 방문할
            // 필요 없음
            // 기 방문한 노드라면 아래 내용 돌지 말고 스킵하고 다음 진행
            if (visited[curNode.target]) {
                continue;
            }
            visited[curNode.target] = true;
            answer += curNode.cost;
            connection++;

            if (connection == n) {
                break;
            }
            // 현재 노드에서 연결된 타겟 노드에 대해서 큐 재시작
            for (Node nextNode : graph.get(curNode.target)) {
                if (!visited[nextNode.target]) {
                    pq.offer(nextNode);
                }
            }

        }

        return answer;
    }
}
