import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {

        HashMap<String,Integer> map = new HashMap<>();
        map.put(begin,words.length);
        for(int i=0; i<words.length; i++) {
            map.put(words[i],i);
        }

        if(!map.containsKey(target)) return 0;

        ArrayList<Integer>[] list = new ArrayList[words.length+1];
        for(int i=0; i<list.length; i++) list[i] = new ArrayList<>();

        for(String a : words) {
            int diff=0;
            for(int i=0; i<a.length(); i++) {
                if(a.charAt(i)!=begin.charAt(i)) diff++;
            }
            if(diff==1) {
                list[map.get(a)].add(map.get(begin));
                list[map.get(begin)].add(map.get(a));
            }
        }

        for(String a : words){
            for(String b : words){

                int diff=0;
                for(int i=0; i<a.length(); i++) {
                    if(a.charAt(i)!=b.charAt(i)) diff++;
                }
                if(diff==1) {
                    list[map.get(a)].add(map.get(b));
                    list[map.get(b)].add(map.get(a));
                }
            }
        }

        Queue<Integer> que = new LinkedList<>();
        int[] dist = new int[words.length+1];
        Arrays.fill(dist, 100);
        que.add(map.get(begin));
        dist[map.get(begin)]=0;

        while(!que.isEmpty()) {
            int now = que.poll();
            for(int next : list[now]) {
                if(dist[next]>dist[now]+1){
                    dist[next] = dist[now]+1;
                    que.add(next);
                }
            }
        }

        return dist[map.get(target)];
    }
}