// PGM 17683 방금그곡
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/17683

import java.util.*;

class Solution {

    public String solution(String m, String[] musicinfos) {
        String answer = "";
        // # 조심하기
        m = change(m);

        // 순서 보장
        String[] musics = new String[musicinfos.length];
        // 노래 별 길이
        HashMap<String, Integer> times = new HashMap<>();
        // 노래 별 전체 재생 문자열
        HashMap<String, String> melodies = new HashMap<>();
        int length = m.length();



        for (int i=0; i<musicinfos.length; i++) {

            String musicInfo = musicinfos[i];
            String[] music = musicInfo.split(",");
            // 시간
            String start = music[0];
            String end = music[1];
            String name = music[2];
            String melody = change(music[3]);
            int melodyLength = melody.length();
            //System.out.println(melody);


            int startTime = Integer.parseInt(start.split(":")[0])*60 + Integer.parseInt(start.split(":")[1]);

            int endTime = Integer.parseInt(end.split(":")[0])*60 + Integer.parseInt(end.split(":")[1]);

            int time = endTime - startTime;
            musics[i] = name;
            times.put(name, time);
            //System.out.println(time);

            // 전체 멜로디
            // 더하고 자르기
            String fullMelody = "";
            int rest = time % melodyLength;
            int cnt = rest == 0 ? time / melodyLength : (time/melodyLength)+1;
            for (int x=0; x<cnt; x++) {
                fullMelody+=melody;
            }

            if (time > fullMelody.length()) {
                fullMelody = fullMelody.substring(0, fullMelody.length()-(melodyLength-rest));
            } else {
                fullMelody = fullMelody.substring(0, time);
            }


            //System.out.println(fullMelody);

            melodies.put(name, fullMelody);
        }
        //System.out.println(times);

        Arrays.sort(musics, (a, b) ->  times.get(b) - times.get(a));
        //System.out.println(Arrays.toString(musics));

        boolean possible = false;
        for (String music: musics) {
            String melody = melodies.get(music);
            if (melody.contains(m)) return music;
        }

        return "(None)";
    }

    private String change(String melody) {
        return melody.replace("A#", "H")
                .replace("C#", "I")
                .replace("D#", "J")
                .replace("F#", "K")
                .replace("G#", "L");
    }

}
