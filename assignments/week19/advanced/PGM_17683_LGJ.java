import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        // 1. 입력 멜로디 변환 # > 소문자로
        m = convertMelody(m);

        for (String info : musicinfos) {
            String[] arr = info.split(",");
            int start = makeMinute(arr[0]);
            int end = makeMinute(arr[1]);
            int playTime = end - start;
            String songName = arr[2];

            // 2. 악보 멜로디도 변환
            String melody = convertMelody(arr[3]);

            // 3. 총 재생된 멜로디 생성
            String total = makeTotal(playTime, melody);
            map.put(songName, total.length());

            // 4. 포함 여부 + 재생시간 비교
            if (total.contains(m) && map.getOrDefault(answer, 0) < total.length()) {
                answer = songName;
            }
        }
        return answer.length() == 0 ? "(None)" : answer;
    }

    int makeMinute(String time) { // HH:MM
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]) * 60;
        int minute = Integer.parseInt(times[1]);
        return hour + minute;
    }

    // 멜로디 변환: #이 붙은 음표를 소문자로 치환
    String convertMelody(String melody) {
        return melody
                .replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a")
                .replaceAll("B#", "b")
                .replaceAll("E#", "e");
    }

    String makeTotal(int playTime, String melody) {
        int length = melody.length();
        if (length > playTime) {
            return melody.substring(0, playTime);
        } else {
            StringBuilder total = new StringBuilder();
            for (int i = 0; i < playTime; i++) {
                total.append(melody.charAt(i % length));
            }
            return total.toString();
        }
    }
}
