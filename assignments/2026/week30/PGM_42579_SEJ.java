// https://school.programmers.co.kr/learn/courses/30/lessons/42579
// 해시맵

import java.util.*;

class Solution {

    public int[] solution(String[] genres, int[] plays) {

        // 장르별 총 재생수
        Map<String, Integer> totalPlay = new HashMap<>();

        // 장르별 노래 목록
        // int[] = {고유번호, 재생수}
        Map<String, List<int[]>> songs = new HashMap<>();

        // 1. 저장
        for (int i = 0; i < genres.length; i++) {

            String genre = genres[i];
            int play = plays[i];

            // 장르 총 재생수
            totalPlay.put(
                genre,
                totalPlay.getOrDefault(genre, 0) + play
            );

            // 장르별 노래 저장
            songs
                .computeIfAbsent(genre, k -> new ArrayList<>())
                .add(new int[]{i, play});
        }


        // 2. 장르를 총 재생수 기준으로 정렬
        List<String> genreList = new ArrayList<>(totalPlay.keySet());

        genreList.sort((g1, g2) ->
            Integer.compare(totalPlay.get(g2), totalPlay.get(g1))
        );


        List<Integer> answer = new ArrayList<>();

        for (String genre : genreList) {

            List<int[]> list = songs.get(genre);

            list.sort((a, b) -> {

                if (a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]);
                }

                return Integer.compare(b[1], a[1]);
            });

            answer.add(list.get(0)[0]);

            if (list.size() >= 2) {
                answer.add(list.get(1)[0]);
            }
        }

        return answer.stream()
                     .mapToInt(Integer::intValue)
                     .toArray();
    }
}
