import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        List<Long> ans = new ArrayList<>();

        for (long num : numbers) {
            String binary = new StringBuilder(Long.toBinaryString(num))
                    .reverse()
                    .append("0")
                    .toString();

            char[] tmp = binary.toCharArray();

            for (int i = 0; i < tmp.length; i++) {
                if (tmp[i] == '0') {
                    tmp[i] = '1';
                    if (i > 0) tmp[i - 1] = '0';
                    break;
                }
            }

            long result = Long.parseLong(
                    new StringBuilder(new String(tmp)).reverse().toString(),
                    2
            );
            ans.add(result);
        }

        long[] resultArr = new long[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            resultArr[i] = ans.get(i);
        }
        return resultArr;
    }
}