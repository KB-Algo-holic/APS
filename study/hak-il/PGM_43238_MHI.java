import java.util.*;
class Solution {
    public long solution(int n, int[] times) {

        Arrays.sort(times);

        long l=1, r=(long)times[times.length-1]*n;

        while(l<r) {

            long mid = (l+r)/2;
            long sum=0;
            boolean big = false;
            for(int i=0; i<times.length; i++){
                sum += (mid/times[i]);
                if(sum>=n) {
                    big=true;
                    break;
                }
            }
            if(big) r=mid;
            else l=mid+1;
        }
        return l;
    }
}