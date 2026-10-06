// LC 2337 - Move Pieces to Obtain a String
// 투포인터
// https://leetcode.com/problems/move-pieces-to-obtain-a-string/description/?utm_source=chatgpt.com

class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length();
        
        int p1 = 0;
        int p2 = 0;

        while (true) {
            while (p1 < n && start.charAt(p1) == '_') {
                p1 ++; 
            }
            
            while (p2 < n && target.charAt(p2) == '_') {
                p2 ++; 
            }
            if (p1 == n && p2 == n) break;
            if (p1 == n || p2 == n) return false;
            if (start.charAt(p1) != target.charAt(p2)) {
                return false;
            } else if (start.charAt(p1) == 'L' && p1 < p2) {
                return false;
            } else if (start.charAt(p1) == 'R' && p1 > p2) {
                return false;
            } else {
                p1 ++;
                p2 ++;
            }
        }

        return true;
    }
}
