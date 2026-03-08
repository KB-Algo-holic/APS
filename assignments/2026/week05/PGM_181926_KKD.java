class Solution {
    public int solution(int n, String control) {
        int answer = n;
        
        for(int i=0;i<control.length();i++)
        {
            char word = control.charAt(i);
            
            if(word == 'w')
                answer++;
            else if(word == 's')
                answer--;
            else if(word == 'd')
                answer += 10;
            else if(word == 'a')
                answer -= 10;
            
        }
        
        return answer;
    }
}
