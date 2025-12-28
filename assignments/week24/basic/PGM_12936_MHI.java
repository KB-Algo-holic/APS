class Solution {
    public int[] solution(int n, long k) {

        long[] mt = new long[n];
        mt[0]=1;
        for(int i=1; i<n; i++) {
            mt[i]=mt[i-1]*i;
        }

        int next=1;
        int[] ans = new int[n];
        boolean[] used = new boolean[n+1];
        k--;

        for(int i=0; i<n; i++) {
            int p = (int)(k/mt[n-1-i]);
            k-=p*mt[n-1-i];
            int count=0;
            for(int j=1; j<=n; j++ )
                if(!used[j]) {
                    if(count==p) {
                        used[j]=true;
                        ans[i] = j;
                        break;
                    }
                    count++;
                }
        }
        return ans;
    }
}