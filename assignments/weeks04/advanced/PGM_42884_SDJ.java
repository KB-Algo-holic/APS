# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 42884 - 단속카메라
# 유형: 그리디
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42884

import java.util.*;

class Solution {
public int solution(int[][] routes) {
	Arrays.sort(routes, new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			if(o1[1]==o2[1]) {
				return o1[0]-o2[0];
			}
			return o1[1]-o2[1]; 
		}
	});   

	int count=0;
	int now = 0;
	for(int idx=0; idx<routes.length; idx++) {

		int start = routes[idx][0];
		int end  = routes[idx][1];
		if(count == 0) { //첫번째는 무조건 카메라 설치
			now = end;
			count++;
		}

		if(now >= start && now <= end) { //이전 구간 안에 있으면 카메라 미설치
		} else {
			now = end;
			count++;
		}
	}
	return count;
	}
}