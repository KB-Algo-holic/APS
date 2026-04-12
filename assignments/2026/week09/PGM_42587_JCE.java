import java.util.Arrays;
import java.util.ArrayList;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        boolean check = false;
        ArrayList<Integer> priorityList = new ArrayList<>();
        
        for(int i = 0; i < priorities.length; i++)
            priorityList.add(priorities[i]);
        
        for(int j = 0; j < priorityList.size(); ){
            check = false;
            for (int k = priorityList.size()-1; k > 0; k--){
                if(priorityList.get(k) > priorityList.get(j)){
                    check = true;
                    if(j == location)
                        location = priorityList.size() -1;
                    else
                        location -= 1;
                    priorityList.add(priorityList.get(j));
                    priorityList.remove(j);
  
                    break;
                }
            }
            if(!check){
                priorityList.remove(j);
                answer += 1;
                if(j == location)
                    return answer;
                else
                    location -= 1;
            }          
        }
        return answer;
    }
}
