// PGM_12915 문자열 내 마음대로 정렬하기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/12915

class Solution {
    public String[] solution(String[] strings, int n) {
        for (int i = 0; i < strings.length - 1; i++){
            for (int j = i + 1; j < strings.length; j++){
                if(strings[j].charAt(n) < strings[i].charAt(n) || strings[i].charAt(n) == strings[j].charAt(n)
                   && compareStrings(strings[i], strings[j], n)){
                    String tmp = new String(strings[i]);
                    strings[i] = strings[j];
                    strings[j] = tmp;
                }
            }
        }
        return strings;
    }
    
    public boolean compareStrings(String str1, String str2, int idx){
        int res = str1.compareTo(str2);
        if(res == 0 || res < 0)
            return false;
        else
            return true;
    }
}
