class Solution {
    public int[] solution(int n) {

        int[][] map = new int[n][n];
        int len = n*(n+1)/2;

        int[] answer = new int[len];
        int r=-1,c=0,how=0, index=0;

        for(int i=1; i<=len; i++){
            if(how==0) r++;
            else if(how==1) c++;
            else {r--; c--;}

            map[r][c]=i;

            if(how==0 && (r+1==n || map[r+1][c]!=0)) how=1;
            else if(how==1 && (c+1==n || map[r][c+1]!=0)) how=2;
            else if (how==2 && (map[r-1][c-1]!=0)) how=0;
        }

        for(int i=0;i<n;i++){
            for(int j=0; j<i+1; j++){
                answer[index++]=map[i][j];
            }
        }
        return answer;
    }
}