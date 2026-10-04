// PGM 64064 - 불량사용자
// DFS
// https://school.programmers.co.kr/learn/courses/30/lessons/64064

import java.util.HashSet;
import java.util.Set;

class Solution {

	
	static Set<Integer> set;
	
	public int solution(String[] user_id, String[] banned_id) {
		
		set = new HashSet<>();
		makeAnswer(user_id, banned_id, 0, 0);
		return set.size();
	}
	static void makeAnswer(String[] user, String[] ban, int next, int bit) {
		
		if(next==ban.length) {
			set.add(bit);
			return;
		}
		
		for(int i=0; i<user.length; i++) {
			if(user[i].length()==ban[next].length()&&(bit&(1<<i))==0) {
				if(match(user[i],ban[next]))
					makeAnswer(user, ban, next+1, bit|(1<<i));
			}
		}
		
	}
	static boolean match(String a, String b) {
		for(int i=0; i<a.length(); i++) {
			if(b.charAt(i)!='*'&&a.charAt(i)!=b.charAt(i)) 
				return false;
		}
		return true;
	}
}