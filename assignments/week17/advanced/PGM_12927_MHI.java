import java.util.*;
class Solution {
    public long solution(int n, int[] works) {

        Arrays.sort(works);

        long sum=0, spare=n;
        int min=works[works.length-1], index=works.length;

        for(int i=works.length-1; i>=0; i--) {
            if(works[i]<min){
                index=i;
                sum = (works.length-1-i)*(min-works[i]);
                if(spare-sum>0) {
                    spare-=sum;
                }
                else break;
                min=works[i];
            }
            if(i==0) index=-1;
        }

        int spareL = works.length-1-index;
        int p = (int)spare/spareL;
        int c = (int)spare%spareL;
        long ans = 0;

        for(int i=index+1; i<works.length; i++) works[i]=min-p;
        for(int i=index+1; i<index+1+c; i++) works[i]--;
        for(int i=0; i<works.length; i++) {
            long next = works[i];
            if(next<0) next=0;
            ans+=next*next;
        }
        return ans;
    }
}