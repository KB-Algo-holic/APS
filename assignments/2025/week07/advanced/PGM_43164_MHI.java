import java.util.*;
class Solution {
    static HashMap<String, ArrayList<Integer>> map;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<String> ans = new ArrayList<>();
    static boolean[] used;
    static String[][] ticket;
    public String[] solution(String[][] tickets) {

        ticket = tickets;
        map = new HashMap<>();
        for(int i=0; i<tickets.length; i++) {
            if(!map.containsKey(tickets[i][0])) map.put(tickets[i][0], new ArrayList<>());
            map.get(tickets[i][0]).add(i);
        }
        used = new boolean[tickets.length];
        sb.append("ICN");
        makeAnswer("ICN",0);

        Collections.sort(ans);
        String first = ans.get(0);
        String[] answer = new String[first.length()/3];
        int index=0;
        for(int i=0; i<first.length(); i+=3){
            answer[index++] = first.substring(i,i+3);
        }
        return answer;
    }
    public void makeAnswer(String now, int len){
        if(len==ticket.length){
            ans.add(sb.toString());
            return;
        }
        if(map.get(now)==null) return;
        for(int next : map.get(now)) {
            if(!used[next]) {
                used[next]=true;
                sb.append(ticket[next][1]);
                makeAnswer(ticket[next][1], len+1);
                used[next]=false;
                sb.delete(sb.length()-3, sb.length());
            }
        }
    }
}