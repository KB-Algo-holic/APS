package week13;

import java.util.PriorityQueue;

public class PGM_42626_HSH {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] s = { 1, 2, 3, 9, 10, 12 };

        int k = 7;
        int answer = solution(s, k);
        System.out.println(answer);
    }


	public static int solution(int[] scoville, int K) {
		int count = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < scoville.length; i++) {
			pq.offer(scoville[i]); // 우선 넣으면 알아서 정리가 됨
		}

		// 우선순위 큐에 의해서 가장 먼저 나올 값은 가장 작은 스코빌 지수의 값 -> K보단 작아야 전체 로직이 돌 수 있음
		while (pq.peek() < K) {
			// 최소 두 개 이상은 있어야함
			if (pq.size() < 2) {
				return -1;
			}
			// 제일 작은거랑 그 다음 작은걸 먼저 뽑는다.
			int min1 = pq.poll();
			int min2 = pq.poll();

			pq.offer((min1 + (min2 * 2)));
			count++;
		}

		return count;
	}
}
