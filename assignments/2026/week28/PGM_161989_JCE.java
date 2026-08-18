class Solution {
    public int solution(int n, int m, int[] section) {

    int answer = 1;
    int rollerStart = section[0];

    for (int i = 1; i < section.length; i++) {
        // 현재 롤러가 커버하는 마지막 칸
        if (rollerStart + m - 1 < section[i]) {
            rollerStart = section[i];
            answer++;
        }
    }

    return answer;

    }
}
