package week11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import org.w3c.dom.Node;

public class PGM_12978_HSH {
    public static void main(String[] args) {
        int n = 5;
        int[][] input = { { 1, 2, 1 }, { 2, 3, 3 }, { 5, 2, 2 }, { 1, 4, 2 }, { 5, 3, 1 }, { 5, 4, 2 } };
        int k = 3;
        PGM_12978_HSH sol = new PGM_12978_HSH();
        int result = sol.solution(n, input, k);
        System.out.println(result);
    }

     public int solution(int N, int[][] road, int K) {
		int answer = 0;
		List<List<Node>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < road.length; i++) {
			// 시작 노드
			int start = road[i][0];
			int destination = road[i][1];
			int cost = road[i][2];
			// 양방향 그래프 구조 만들기 (시작 - 도착 - cost) , (도착 - 시작 - cost)
			graph.get(start).add(new Node(destination, cost));
			graph.get(destination).add(new Node(start, cost));

		}

		// cost가 K 이하인 경우 result 뽑기
		answer = getDistance(graph, N, K);
		return answer;
     }
    
     	private static int getDistance(List<List<Node>> graph, int N, int K) {
		int[] distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		PriorityQueue<Node> pq = new PriorityQueue<>();
		// 1번 마을에서 시작
		distance[1] = 0;
		pq.offer(new Node(1, 0));
		// 다익스트라 알고리즘 -> 최단거리 구하기 (합계로 최단거리가 K를 넘으면 더 할 필요가 없기 떄문)
		while (!pq.isEmpty()) {
			Node current = pq.poll(); // 우선순위 큐에 들어간 노드 꺼내기 (현위치) > 비용이 작은노드 처리하기
			int now = current.village;
			int cost = current.cost;

			if (cost > distance[now]) {
				continue; // 현재 드는 비용이 현재 위치에서 이동할 비용보다 크면 넘어가기
			}

			for (Node nextNode : graph.get(now)) {
				int next = nextNode.village;
				int nextCost = nextNode.cost + cost; // 다음 노드까지 가는 비용 = 현 노드까지 가는 비용 + 현 노드에서 다음 노드까지 가는 비용

				// 다음 노드까지 가는 거리에 대한 비용이 더 많으면(현 노드 -> 다음 노드 연결된 비용보다)
				// 그러면 한 번 더 갈 수 있는거라서 pq에 넣고 다시 수행
				if (nextCost < distance[next]) {
					distance[next] = nextCost;
					pq.offer(new Node(next, nextCost));
				}
			}
		}

		int answer = 0;
		for (int i = 0; i <= N; i++) {
			if (distance[i] <= K) {
				answer++;
			}
		}
		return answer;
	}
    
    private static class Node implements Comparable<Node> {
        int village;
        int cost;

        Node(int village, int cost) {
            this.village = village;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            // TODO Auto-generated method stub
            return this.cost - other.cost;
        }

    }
}