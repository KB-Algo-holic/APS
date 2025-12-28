import java.util.HashSet;
import java.util.Set;

class Solution {

    public int solution(int m, int n, String[] board) {

        char[][] map = new char[m][n];
        for(int i=0; i<board.length; i++) {
            map[i] = board[i].toCharArray();
        }
        Set<Integer> set;
        int ans=0;
        while(true) {

            set = new HashSet<>();

            for(int i=0; i<m-1; i++) {
                for(int j=0; j<n-1; j++) {
                    if(map[i][j]!=' '&&
                            map[i][j]==map[i][j+1]&&
                            map[i][j]==map[i+1][j]&&
                            map[i][j]==map[i+1][j+1]) {
                        set.add(i*n+j);
                        set.add(i*n+j+1);
                        set.add((i+1)*n+j);
                        set.add((i+1)*n+j+1);
                    }
                }
            }
            if(set.size()==0) break;
            else ans+=set.size();
            for(int next : set) {
                map[next/n][next%n]=' ';
            }
            boolean finish = true;
            while(finish) {
                finish=false;
                for(int r=m-2; r>=0; r--) {
                    for(int c=0; c<n; c++) {
                        if(map[r][c]!=' '&&map[r+1][c]==' ') {
                            finish=true;
                            map[r+1][c]=map[r][c];
                            map[r][c]=' ';
                        }
                    }
                }
            }


        }
        return ans;
    }
}