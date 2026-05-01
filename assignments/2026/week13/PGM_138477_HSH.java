package week13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PGM_138477_HSH {
    private static int[] minResults;

    public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] score = { 10, 100, 20, 150, 1, 100, 200 };
		int size = score.length;
		minResults = new int[size];
		minResults = solution(3, score);
		for (int elem : minResults) {
			System.out.print(elem + " ");
		}
	}

	public static int[] solution(int k, int[] score) {
		List<Integer> middlewareList = new ArrayList<Integer>();
		List<Integer> minList = new ArrayList<Integer>();

		for (int i = 0; i < score.length; i++) {
			int value = 0;
			middlewareList.add(score[i]); // 순차적으로 넣고 이 넣은 값을 배열로 만들어서 작은걸 리스트에 넣어주는 과정
			// K번째까지는 무조건 낮은 값이 반환
			if (k > i) {
				value = minValue(middlewareList.stream().mapToInt(Integer::intValue).toArray());
				minList.add(value); // k번째까지는 가장 낮은 값을 넣어주기
			}
			else {
				value = minValue(middlewareList.stream().mapToInt(Integer::intValue).toArray()); // 최저값을 찾아서 빼주기 위함
				middlewareList.remove(Integer.valueOf(value)); // 빼고 나서! 다시 최저값을 구해서 넣어준다.
				// 리스트에서 제외한 거에서 다시 최저값을 찾아서 넣어줘야함
				value = minValue(middlewareList.stream().mapToInt(Integer::intValue).toArray());
				minList.add(value);
			}
		}
		return minList.stream().mapToInt(Integer::intValue).toArray();
	}

	public static int minValue(int[] score) {
		int answer = Arrays.stream(score).min().getAsInt(); // 배열중 가장 작은 값을 출력해내는 함수
		return answer;
	}
}
