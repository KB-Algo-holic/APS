// PGM - 161989 덧칠하기
// 그리디
// https://school.programmers.co.kr/learn/courses/30/lessons/161989
import java.util.HashSet;
import java.util.Set;

public class PGM_161989_YHS {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        Set<Integer> set = new HashSet();
        for(int i=0; i<section.length; i++){
            int sec = section[i];
            if(!set.contains(sec)){
                answer++;
                for(int j=0; j<m; j++){
                    set.add(sec+j);
                }
            }
        }
        return answer;
    }
}
