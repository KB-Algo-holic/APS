// PGM 모음 사전 - 84512
// DFS 완전탐색
// https://school.programmers.co.kr/learn/courses/30/lessons/84512
import java.util.*;

class Solution {
    
    private String[] dic = {"A","E","I","O","U"};
    private ArrayList<String> list;
    
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList();
        
        dfs(0,"");
        
        //System.out.println(list.toString());
        for(int i=0;i<list.size();i++)
        {
            if(word.equals(list.get(i)))
            {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    public void dfs(int count,String word)
    {
        list.add(word);
        if(count == 5)
        {
            return;
        }
        
        for(int i=0;i<5;i++)
        {
            word = word + dic[i];
            dfs(count+1,word);
            word = word.substring(0,word.length()-1);
        }
        
    }
}
