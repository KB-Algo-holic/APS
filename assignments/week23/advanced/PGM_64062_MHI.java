class Solution {

    public int solution(int[] stones, int k) {

        int l=1,r=200000000;

        while(l<r) {

            int mid=(l+r)/2;
            int count=0;

            for(int i=0; i<stones.length; i++) {
                if(stones[i]<=mid) {
                    count++;
                    if(count==k) {
                        r=mid;
                        break;
                    }
                }
                else count=0;
            }
            if(r!=mid) l=mid+1;
        }
        return l;
    }
}