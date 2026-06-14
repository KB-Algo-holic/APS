package week19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PGM_72412_HSH {
    private static Map<String, ArrayList<Integer>> map;

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        System.out.println(solution(info, query));
    }
    public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];

		// 조건값과 '-' 이 더해져서 경우의 수가 만들어짐: 총 4가지(언어, 직군, 경력, 음식)에 대한 조건식은 2^4 경우의 수가 발생
		// "-", 값 (한 경우당 두 가지 경우의 수)^4 ~> 이건 사용자 점수에 맞춰 가능하기 때문
		// 각 경우의 수에 대해서 발생 가능한 점수를 체크해야함

		map = new HashMap<>();
		for (String infoStr : info) {
			String[] infoItem = infoStr.split(" ");

			String[] conditions = { infoItem[0], // 언어
					infoItem[1], // 직군
					infoItem[2], // 경력
					infoItem[3], // 음식
			};

			int score = Integer.parseInt(infoItem[4]); // 점수
			// 하나의 문장에 대해서 16가지의 경우의 수가 나오기 때문에 이렇게 처리하되, 바이트 이동을 통해 값 변경
			for (int mask = 0; mask < 16; mask++) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < 4; i++) {
					if ((mask & (1 << i)) != 0) {
						sb.append("-");
					} else {
						sb.append(conditions[i]);
					}
				}
				// 값을 넣어주되, 비어있다면 점수만 넣어주기
				map.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(score);
			}
		}
		// map에 들어간거 key 별로 리스트 정렬 
		for(ArrayList<Integer> scoreList : map.values()) {
			Collections.sort(scoreList);
		}

		for (int i = 0; i < query.length; i++) {
			String[] qstr = query[i].split(" and | ");
			String lang = qstr[0]; // 언어 (cpp, java, python)
			String job = qstr[1]; // 직군 (backend, frontend)
			String career = qstr[2]; // 경력 (junior, senior)
			String food = qstr[3]; // 소울푸드 (pizza, chicken)
			StringBuilder sb2 = new StringBuilder();
			sb2.append(lang);
			sb2.append(job);
			sb2.append(career);
			sb2.append(food);
			
			int score = Integer.parseInt(qstr[4]); // 점수
			// 정보값이랑 비교하기
			// 여기서 반복이 더 도니까 시간이 많이 걸리는듯... 여기서 쿼리한거에 대해서 이분탐색을 진행해보자
			ArrayList<Integer> scoreList = map.getOrDefault(sb2.toString(), new ArrayList<>());
			
			int index = isLowerCheck(scoreList, score);
			
			answer[i] = scoreList.size() - index;
		}
		return answer;
	}

	private static int isLowerCheck(ArrayList<Integer> scoreList, int score) {
		// TODO Auto-generated method stub
		int left = 0;
		int right = scoreList.size();
		while(left < right) {
			int mid = (left + right) / 2;
			if(scoreList.get(mid) >= score) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}
