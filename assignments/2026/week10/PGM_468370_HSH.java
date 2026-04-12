package week10;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
public class PGM_468370_HSH {

    static class WordInfo {
        int start;
        int end;
        String word;
        boolean isSpoiler;
        int revealOrder; // 몇 번째 spoiler 클릭 때 완전히 공개되는지

        WordInfo(int start, int end, String word) {
            this.start = start;
            this.end = end;
            this.word = word;
            this.isSpoiler = false;
            this.revealOrder = -1;
        }
    }
    public static void main(String[] args) {
		String input1 = "my phone number is 01012345678 and may i have your phone number";
		int input2[][] = { { 5, 5 }, { 25, 28 }, { 34, 40 }, { 53, 59 } };

		int result = solution(input1, input2);
		System.out.println(result); // 4
    }  

    static private int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;

        // 1. message를 단어 단위로 분리하면서 시작/끝 인덱스 저장
        List<WordInfo> wordList = new ArrayList<>();

        int idx = 0;
        while (idx < message.length()) {
            if (message.charAt(idx) == ' ') {
                idx++;
                continue;
            }

            int start = idx;
            while (idx < message.length() && message.charAt(idx) != ' ') {
                idx++;
            }
            int end = idx - 1;

            String word = message.substring(start, idx);
            wordList.add(new WordInfo(start, end, word));
        }

        // 2. 각 단어가 spoiler 범위와 겹치는지 체크
        int r = 0;
        int rangeCount = spoiler_ranges.length;

        for (int i = 0; i < wordList.size(); i++) {
            WordInfo w = wordList.get(i);

            while (r < rangeCount && spoiler_ranges[r][1] < w.start) {
                r++;
            }

            int temp = r;
            while (temp < rangeCount && spoiler_ranges[temp][0] <= w.end) {
                // 단어와 spoiler 구간이 겹침
                w.isSpoiler = true;
                w.revealOrder = temp; // 마지막으로 겹친 spoiler 구간 순서
                temp++;
            }
        }

        // 3. 스포일러가 아닌 구간에 나온 단어들 기록
        Map<String, Integer> normalWordCount = new HashMap<>();

        for (WordInfo w : wordList) {
            if (!w.isSpoiler) {
                normalWordCount.put(w.word, normalWordCount.getOrDefault(w.word, 0) + 1);
            }
        }

        // 4. 각 클릭 시점에 공개되는 단어들 저장
        List<List<WordInfo>> revealList = new ArrayList<>();
        for (int i = 0; i < spoiler_ranges.length; i++) {
            revealList.add(new ArrayList<>());
        }

        for (WordInfo w : wordList) {
            if (w.isSpoiler) {
                revealList.get(w.revealOrder).add(w);
            }
        }

        // 5. 클릭 순서대로 중요한 단어 판정
        HashSet<String> countedImportantWords = new HashSet<>();

        for (int i = 0; i < spoiler_ranges.length; i++) {
            List<WordInfo> currentWords = revealList.get(i);

            for (WordInfo w : currentWords) {
                // 1) 스포일러 단어여야 함 (이미 만족)
                // 2) 스포일러가 아닌 구간에 등장한 적 없어야 함
                if (normalWordCount.containsKey(w.word)) {
                    continue;
                }

                // 3) 이전에 공개된 중요한 단어와 중복되지 않아야 함
                if (countedImportantWords.contains(w.word)) {
                    continue;
                }

                countedImportantWords.add(w.word);
                answer++;
            }
        }

        return answer;
    }
}
