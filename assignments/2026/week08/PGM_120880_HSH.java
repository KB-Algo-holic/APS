import java.util.PriorityQueue;

public class PGM_120880_HSH {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numberlist = { 10000, 20, 36, 47, 40, 6, 10, 7000 };
		int n = 30;
		try {
			int[] result = solution(numberlist, n);
			for (int i = 0; i < result.length; i++) {
				if (i < result.length - 1)
					System.out.print(result[i] + ", ");
				else 
					System.out.print(result[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static int[] solution(int[] numlist, int n) {
		int size = numlist.length;
		int answer[] = new int[size];
		/***
		 * 다음 문제의 핵심은 n과의 거리로 같은 거리면 큰 값을 반환하고
		 * 평소에는 거리가 더 가까운 것을 반환하는 것입니다. 
		 * 
		 * 1) 거리가 가까운 것을 반환하기
		 * 2) 거리가 동일하다면 큰 값을 반환하기
		 * 
		 * 다음 두 조건이 우선순위 규칙으로 정의되어 우선순위 큐에 값을 넣고 반환(poll)할 때 
		 * 자동으로 규칙에 맞춰서 우선순위가 정해져서 반환됩니다. 
		 * 이는 다음 문제에 핵심 내용입니다. 
		 * 
		 */
		
		// 1, 2 규칙을 모두 적용하되, 기본적으로는 거리값으로 먼저 반환을 하는 것
		PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
			int diffA = Math.abs(a - n);
			int diffB = Math.abs(b - n);

			if (diffA == diffB) {
				return b - a;
			}

			return diffA - diffB;
		});
		// 배열에 있는 값을 그대로 우선순위 큐에 넣어주기
		for (int num : numlist) {
			queue.offer(num);
		}
		int i = 0;
		// 큐에 값들을 반환할 때는 자동으로 다음 우선순위 규칙에 따라서(1, 2) 올바르게 반환함 
		// 이를 배열에 넣고 리턴해주면 해당 문제는 모두 해결
		while (!queue.isEmpty()) {
			answer[i++] = queue.poll();
		}

		return answer;
	}
}

