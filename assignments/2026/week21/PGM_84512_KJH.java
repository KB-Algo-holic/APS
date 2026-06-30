class Solution {
    public int solution(String word) {
        int answer = 0;
         
        int[] weights = {781, 156, 31, 6, 1};
         
        String vowels = "AEIOU";
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = vowels.indexOf(c); // A=0, E=1, I=2, O=3, U=4
            
            answer += index * weights[i] + 1;
        }
        return answer;
    }
}
