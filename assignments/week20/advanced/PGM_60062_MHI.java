import java.util.*;
class Solution {
    static int N, lenW, ans=Integer.MAX_VALUE;
    static int[] w, d;
    static Stack<Integer> st;
    public int solution(int n, int[] weak, int[] dist) {

        N = n;
        lenW = weak.length;
        w = new int[weak.length*2];
        for(int i=0; i<w.length; i++) {
            w[i]=weak[i%weak.length]+(i/weak.length)*N;
        }
        d = dist;

        st = new Stack<>();
        makeAnswer(0);
        if(ans==Integer.MAX_VALUE) ans=-1;
        return ans;
    }
    static void makeAnswer(int bit) {

        for(int i=0; i<lenW; i++) {
            int from = i;
            int to = i+lenW;
            for(int friend : st) {
                int dist=0;
                while(from<to) {
                    dist+=w[from+1]-w[from];
                    from++;
                    if(d[friend]<dist) {
                        break;
                    }
                }

            }
            if(from==to) {
                ans=Math.min(ans, st.size());
                return;
            }
        }

        for(int i=0; i<d.length; i++) {
            if((bit&(1<<i))==0) {
                st.push(i);
                makeAnswer(bit|(1<<i));
                st.pop();
            }
        }
    }
}