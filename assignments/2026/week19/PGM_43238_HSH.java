package week19;

import java.util.Arrays;

public class PGM_43238_HSH {
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] times = { 10, 7 };
		int n = 6;

		long result = solution(n, times);
		System.out.println(result);
	}

	public static long solution(int n, int[] times) {
		long answer = 0;
		Arrays.sort(times);
		long start = 1; // 최소 심사 걸리는 시간 1분
		long end = (long) n * (times[times.length - 1]); // 배열의 마지막 위치에 값으로 n명이 다 수행될 때가 가장 최대 시간이 걸린다고 정의
		// 체크하는건 시간으로 처리하는거라서 이렇게 잡
		while(start <= end) {
			long mid = (start + end) / 2;
			// 실제로는 처리 양을 체크해야 하므로 중간값 
			long processAmount = 0;
			for (int i = 0; i < times.length; i++) {
				processAmount += mid / times[i];
			}
			// 
			if(processAmount >= n) {
				answer = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		return answer;
	}
}
