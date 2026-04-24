import java.util.*;

// PGM - 42579 L3_베스트앨법
// 해시
// https://school.programmers.co.kr/learn/courses/30/lessons/42579
public class PGM_42579_YHS {
    Map<String, Integer> priority = new HashMap<>();
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, Integer> map = new HashMap<>();
        List<Music> musicList = new ArrayList<>();

        int size = genres.length;
        for(int i=0; i<size; i++){
            String g = genres[i];
            int p = plays[i];
            musicList.add(new Music(i, g, p));

            if(map.get(g) == null){
                map.put(g, p);
            }else{
                map.put(g, map.get(g)+p);
            }
        }

        List<Music> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            list.add(new Music(0, entry.getKey(), entry.getValue()));
        }
        Collections.sort(list);

        int idx = 0;
        for(int i=0; i<list.size(); i++){
            if(priority.get(list.get(i).genre) == null){
                priority.put(list.get(i).genre, idx++);
            }
        }

        Collections.sort(musicList);

        Map<String, Integer> count = new HashMap<>();
        for(int i=0; i<musicList.size(); i++){
            String g = musicList.get(i).genre;
            if(count.get(g) == null){
                count.put(g, 1);
            }else if(count.get(g) == 1){
                count.put(g, 2);
            }else{
                musicList.remove(i--);
            }
        }

        answer = new int[musicList.size()];

        for(int i=0; i<musicList.size(); i++){
            answer[i] = musicList.get(i).no;
        }

        return answer;
    }

    class Music implements Comparable<Music>{
        int no;
        String genre;
        int play;

        public Music(int no, String genre, int play){
            this.no = no;
            this.genre = genre;
            this.play = play;
        }

        @Override
        public int compareTo(Music o){
            if(priority.get(this.genre) == priority.get(o.genre)){
                if(this.play == o.play){
                    return Integer.compare(this.no, o.no);
                }
                return Integer.compare(o.play, this.play);
            }
            return Integer.compare(priority.get(this.genre), priority.get(o.genre));
        }
    }
}
