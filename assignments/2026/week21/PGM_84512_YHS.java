// PGM - 84512 L2_모음사전
// 완전탐색
// https://school.programmers.co.kr/learn/courses/30/lessons/84512?language=java
public class PGM_84512_YHS {
    int cnt, answer;

    public int solution(String word) {
        solve("", new char[]{'A','E','I','O','U'}, word);

        return answer;
    }

    void solve(String cur, char[] aeiou, String word){
        if(cur.equals(word)){
            answer = cnt;
            return;
        }
        cnt++;

        if(cur.length() == 5){
            return;
        }

        for(int i=0; i<5; i++){
            solve(cur + aeiou[i], aeiou, word);
        }
    }
}
