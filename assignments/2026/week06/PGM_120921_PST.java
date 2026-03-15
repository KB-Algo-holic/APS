// PGM 120921 - 문자열 밀기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/120921
class Solution {
    public int solution(String A, String B) {

        if (A.equals(B)) {
            return 0;
        }

        char[] strArray = A.toCharArray();
        int strLength = strArray.length;

        for(int i=1;i<strLength;i++){

            char lastChar = strArray[strLength-1];

            for (int j=strLength-1;j>0;j--) {
                strArray[j] = strArray[j-1];
            }

            strArray[0] = lastChar;

            if (new String(strArray).equals(B)) {
                return i;
            }
        }

        return -1;
    }

}