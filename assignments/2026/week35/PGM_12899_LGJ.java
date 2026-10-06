// PGM 12899 - 124 나라
// 구현 
// https://school.programmers.co.kr/learn/courses/30/lessons/12899?language=java


class Solution {
    public String solution(int n) {
        String answer = "";
		
		// 25
		while (n>0) {
			int div = n / 3; // 8 -> 2 -> 2
			int rest = n % 3; // 1 -> 2 -> 0
			
			
			if (rest == 0) {
				rest = 4;
				div -= 1;
			} 
			
			answer = Integer.toString(rest) + answer;
			
			n = div;
			
			
		}
		
        return answer;
    }
}
