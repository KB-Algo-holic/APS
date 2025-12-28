import java.util.*;


class PGM_138476 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> sizeCntMap = new HashMap<>();

        for (int size: tangerine) {
            Integer temp = sizeCntMap.get(size);
            if (temp == null) {
                sizeCntMap.put(size, 1);
            } else {
                sizeCntMap.put(size, temp+1);
            }
        }
        List<Integer> sizeList = new ArrayList<>(sizeCntMap.keySet());
        sizeList.sort((s1, s2) -> sizeCntMap.get(s2).compareTo(sizeCntMap.get(s1)));

        for (int size: sizeList) {
            int cnt = sizeCntMap.get(size);
            if (k > 0) {
                k -= cnt;
                answer += 1;
            }
            else break;

        }


        return answer;
    }
}