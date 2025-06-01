// PGM 12985 - 예상대진표
// 유형: 구현
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12985

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;

        while((a + 1) / 2 != (b + 1) / 2) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }

        return answer;
    }
}