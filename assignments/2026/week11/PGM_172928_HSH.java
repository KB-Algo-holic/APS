package week11;

import java.util.HashMap;
import java.util.Map;

public class PGM_172928_HSH {
    public static void main(String[] args) {
        String[] input1 = { "SOO", "OOO", "OOO" };
        String[] input2 = { "E 2", "S 2", "W 1" };
        PGM_172928_HSH sol = new PGM_172928_HSH();
        int[] result = sol.solution(input1, input2);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }

     public int[] solution(String[] park, String[] routes) {
// 행
		int w = park.length;
		// 열
		int h = park[0].length();

		Map<String, int[]> direction = new HashMap<>();

		direction.put("N", new int[] { -1, 0 });
		direction.put("E", new int[] { 0, 1 });
		direction.put("W", new int[] { 0, -1 });
		direction.put("S", new int[] { 1, 0 });
		String maze[][] = new String[w][h];

		// 시작 위치 정하기
		int x = 0;
		int y = 0;
		for (int i = 0; i < park.length; i++) {
			for (int j = 0; j < park[i].length(); j++) {
				maze[i][j] = String.valueOf(park[i].charAt(j));
				if (park[i].charAt(j) == 'S') {
					x = i;
					y = j;
				}
			}
		}
		/**
		 * direction[0] -> 동쪽, direction[1] -> 서쪽, direction[2] -> 남쪽, direction[3] ->
		 * 북쪽
		 */

		for (int i = 0; i < routes.length; i++) {
			String dir = routes[i].split(" ")[0]; // 방
			String walkCount = routes[i].split(" ")[1]; // 걷는 횟수
			
			int prevX = x; // 이동할 위치는 x가 되고 이전 위치는 prevX
			int prevY = y; // 이동할 위치는 y가 되고 이전 위치는 prevY
			// 처음 시작은 S의 위치가 될 것이고 걸어가는 횟수만큼 방향대로 이동
			int moveX = direction.get(dir)[0]; // 방향성에 따른 좌우
			int moveY = direction.get(dir)[1]; // 방향성에 따른 상하

			for (int j = 0; j < Integer.parseInt(walkCount); j++) {
				x += moveX;
				y += moveY;
                // 범위 내에서 이동해야하며 장애물인 X가 있다면 이동하지 않고 다시 돌아가야함 (즉, 이전 위치로 갈 것)
				if ((x >= 0 && x < park.length) && (y >= 0 && y < park[x].length())) {
					if (maze[x][y].equals("X")) {
						x = prevX;
						y = prevY;
						break;
					}
				} 
                // 마찬가지로 범위 밖이면 이전으로 돌아갈 것
                else {
					x = prevX;
					y = prevY;
					break;
				}
			}
		}
		return new int[] { x, y };
    }
}
