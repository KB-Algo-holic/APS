// PGM 17681 - 비밀지도
// 유형 : 
// 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/17681?language=java

public class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int count = 0;
        for(int i=0;i<n;i++){
            count = 0;
            answer[i] = (Integer.toBinaryString(arr1[i] | arr2[i]));
            if(answer[i].length()!=n) count = n-answer[i].length();
            for(int j=0;j<count;j++)  answer[i]="0"+answer[i];
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                answer[i] = answer[i].replace("1","#");
                answer[i] = answer[i].replace("0"," ");
            }
        }

        return answer;
    }
}
