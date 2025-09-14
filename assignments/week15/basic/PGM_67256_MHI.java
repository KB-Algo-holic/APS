class Solution {
    public String solution(int[] numbers, String hand) {

        int nowL=9, nowR=11;

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numbers.length; i++) {

            if(numbers[i]==0) numbers[i]=10;
            else numbers[i]--;

            if(numbers[i]%3==0) {
                nowL=numbers[i];
                sb.append("L");
            }
            else if(numbers[i]%3==2) {
                nowR=numbers[i];
                sb.append("R");
            }
            else {
                if(len(numbers[i],nowL)>len(numbers[i],nowR)) {
                    nowR=numbers[i];
                    sb.append("R");
                }
                else if(len(numbers[i],nowL)<len(numbers[i],nowR)) {
                    nowL=numbers[i];
                    sb.append("L");
                }
                else if(hand.equals("right")) {
                    nowR=numbers[i];
                    sb.append("R");
                }
                else {
                    nowL=numbers[i];
                    sb.append("L");
                }
            }
        }

        String answer = sb.toString();
        return answer;
    }
    static int len(int a, int b) {
        int aX=a%3, aY=a/3, bX=b%3,bY=b/3;
        return Math.abs(aX-bX)+Math.abs(aY-bY);
    }
}