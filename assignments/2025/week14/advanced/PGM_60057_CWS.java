// PGM 60057 - 문자열압축
// 유형: 문자열
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/60057

class Solution {
    public int solution(String s) {

        StringBuilder sb = new StringBuilder();

        int size = 1; //자를 문자열 갯수
        int sum = 1;
        int answer = s.length();

        for (int i = size; i <= s.length()/2; i++) {

            int a = 0; //비교할 문자열의 시작 인덱스
            int b = a+size; //비교당할 문자열의 시작 인덱스
            int result = 0; //결과값

            while(b + size <= s.length()) {
                String wordA = s.substring(a, a + size);
                String wordB = s.substring(b, b + size);
                if(wordA.equals(wordB)) { //비교할 문자열이 다음 비교당할 문자열과 같을 경우
                    b += size; //비교당할 문자열의 시작 인덱스 증가
                    sum++;
                }else { //문자열이 다음 문자열과 다를 경우
                    if(sum != 1)
                        sb.append(sum+wordA);
                    else
                        sb.append(wordA);
                    a = b; //비교할 문자열의 시작 인덱스 증가
                    b += size; //비교당할 문자열의 시작 인덱스 증가
                    if(sum > 1)
                        result += sum * size;
                    sum = 1;
                }
            }
            if(sum != 1)
                sb.append(sum + s.substring(a, a + size));
            else
                sb.append(s.substring(a, a + size));

            sum = 1;

            if(sb.length() < s.length())
                sb.append(s.substring(b, s.length()));



            result = sb.length();
            sb.setLength(0);
            answer = Math.min(answer, result);
            size++;
        }

        return answer;
    }
}