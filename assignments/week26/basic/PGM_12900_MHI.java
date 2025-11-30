class Solution {
    public int solution(int n) {
        int MOD = 1000000007;
        int one=1, two=2;
        int sum=0;
        for(int i=3; i<=n; i++) {
            sum = (one+two)%MOD;
            one=two;
            two=sum;
        }


        return sum;
    }
}