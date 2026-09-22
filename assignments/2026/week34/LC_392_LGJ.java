// LC 392 - Is Subsequence
// 투포인터? 
// https://leetcode.com/problems/is-subsequence

class Solution {
    public boolean isSubsequence(String s, String t) {
		int p1 = 0;
		StringBuilder sb = new StringBuilder();
		for (char c: t.toCharArray()) {
			if (p1 >= s.length()) break;
			if (c == s.charAt(p1)) {
				sb.append(c);
				p1 += 1;
			}
		}
		
		return s.equals(sb.toString());
		
    }
}
