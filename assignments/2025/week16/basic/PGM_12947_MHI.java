class Solution {
    public boolean solution(int x) {
        String num = String.valueOf(x);
        int sum = 0;
        for (char c : num.toCharArray()) {
            sum += Integer.parseInt(c+"");
        }
        return x % sum == 0;
    }
}