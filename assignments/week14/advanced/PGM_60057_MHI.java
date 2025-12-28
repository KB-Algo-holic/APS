class Solution {
    public int solution(String s) {

        if(s.length()==1) return 1;
        int ans=Integer.MAX_VALUE;
        int len = s.length()/2;
        for(int size=1; size<=len; size++) {
            int min=0;
            for(int index2=size; index2<=s.length(); index2+=size) {
                int count=1;
                int index1=index2+size;
                while(index1<=s.length()) {
                    if(s.substring(index1-size, index1).equals(s.substring(index2-size, index2))) {
                        index1+=size;
                        count++;
                    }
                    else break;
                }
                index2=index1-size;
                int plus = count==1 ? 0 : String.valueOf(count).length();
                min+=size+plus;
            }
            min+=s.length()%size;

            ans=Math.min(ans, min);
        }

        return ans;
    }
}