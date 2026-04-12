// PGM - 42579 베스트앨범
// 해쉬 및 정렬
// https://school.programmers.co.kr/learn/courses/30/lessons/42579?language=java


import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        HashMap<String, List<int[]>> songInfosByGenre = new HashMap<>();
        HashMap<String, Integer> songCntByGenre = new HashMap<>();

        for (int i=0; i<n; i++) {
            String genre = genres[i];
            Integer playCnt = plays[i];
            int[] songInfo = {i, playCnt};
            // 장르 통계
            songCntByGenre.put(genre, songCntByGenre.getOrDefault(genre, 0)+playCnt);
            songInfosByGenre.computeIfAbsent(genre, k -> new ArrayList<>()).add(songInfo);
        }
        List<Map.Entry<String, Integer>> genreCnt = new ArrayList<>(songCntByGenre.entrySet());
        Collections.sort(genreCnt, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        List<Integer> bestAlbumsList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: genreCnt) {
            String genre = entry.getKey();
            List<int[]> genreInfoList = songInfosByGenre.get(genre);
            Collections.sort(genreInfoList, (a, b) -> b[1] - a[1]);
            for (int i=0; i<genreInfoList.size(); i++) {
                if (i==2) break;
                bestAlbumsList.add(genreInfoList.get(i)[0]);
            }
        }

        int[] bestAlbumsArr = new int[bestAlbumsList.size()];
        for (int i=0; i<bestAlbumsList.size(); i++) bestAlbumsArr[i] = bestAlbumsList.get(i);
        return bestAlbumsArr;
    }
}