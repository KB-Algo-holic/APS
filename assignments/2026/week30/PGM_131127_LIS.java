// PGM 131127 - 할인행사
// 학습 
// https://school.programmers.co.kr/learn/courses/30/lessons/131127?language=java
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for(int i = 0; i < discount.length-9; i++) {
            int j;
            for(j = 0; j < want.length; j++) {
                int check = 0;
                for(int k = i ; k < i + 10; k++) {
                    if(discount[k].equals(want[j])) check++;
                }        
                if(check<number[j]) {
                     break;
                }
            }
           if(j == want.length) answer ++;
        }
        return answer;
    }
}
