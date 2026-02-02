class Solution {
    public boolean solution(int x) {
        String tempStr = Integer.toString(x);
        
        int sum = 0;
        for(int i=0; i< tempStr.length(); i++) {
            char c = tempStr.charAt(i);
            sum += Integer.parseInt(Character.toString(c));
        }
        if(x%sum == 0) {
            return true;
        }
        
        return false;
    }
}