// PGM 120893 - 대문자와 소문자
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/120893
class Solution {
    public String solution(String my_string) {

        char[] strArray = my_string.toCharArray();

        for(int i=0;i<strArray.length;i++){

            char str = strArray[i];
            if (Character.isUpperCase(str)) {
                strArray[i] = Character.toLowerCase(str);
            } else {
                strArray[i] = Character.toUpperCase(str);
            }
        }
        return new String(strArray);
    }
}