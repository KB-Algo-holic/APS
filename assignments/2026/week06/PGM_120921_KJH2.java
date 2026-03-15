// PGM_120921 문자열밀기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/120921
class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        if(A.equals(B))
            return answer;
        StringBuilder sb = new StringBuilder(A);
        for(int i = 0; i < sb.length(); i ++){
            char tmp = sb.charAt(sb.length() - 1);
            sb.insert(0, tmp);
            sb.delete(sb.length() - 1, sb.length());
            answer++;
            if(sb.toString().equals(B))
                return answer;
        }
        
        return -1;
    }
}