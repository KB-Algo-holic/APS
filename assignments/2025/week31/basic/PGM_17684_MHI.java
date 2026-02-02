import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int[] solution(String msg) {

        Map<String,Integer> map = new HashMap<>();
        for(int i=1; i<27; i++) {
            map.put(String.valueOf((char)('A'+i-1)),i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        int index=0;
        msg = msg+"a";
        for(int i=0; i<msg.length(); i=index-1) {

            index=i+1;
            while(index<=msg.length()) {
                if(!map.containsKey(msg.substring(i,index))) {
                    list.add(map.get(msg.substring(i,index-1)));
                    map.put(msg.substring(i,index),map.size()+1);
                    break;
                }
                index++;
            }
        }
        int[] answer = new int[list.size()-1];
        for(int i=0; i<list.size()-1; i++) {
            answer[i]=list.get(i);
        }

        return answer;
    }
}