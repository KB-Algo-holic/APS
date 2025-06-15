import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int num = citations.length - i;
            if (citations[i] >= num) {
                return num;
            }
        }

        return 0;
    }
}