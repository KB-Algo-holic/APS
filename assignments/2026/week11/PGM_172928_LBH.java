// 공원 산책
// 그래프
// https://school.programmers.co.kr/learn/courses/30/lessons/172928

class Solution {

    public int[] move(String[] park, int row, int col, int i, int j, int limit, int dist) {
        int time = 0;
        
        while(time++ < dist) {
            if(row + i != limit && col + j != limit) {
                if(park[row + i].charAt(col + j) == 'X') {
                    return new int[]{-1, -1};
                } else {
                    row = row + i;
                    col = col + j;
                }
            } else {
                return new int[]{-1, -1};
            }
        }
            
        return new int[]{row, col};
    }

    public int[] solution(String[] park, String[] routes) {

        for(int row = 0; row < park.length; row++) {
            for(int col = 0; col < park[0].length(); col++) {
                if(park[row].charAt(col) == 'S') {
                    
                    int[] rowCol = new int[2];
                    
                    for(String route : routes) {
                        char dir = route.charAt(0);
                        int dist = (int)(route.charAt(2) - '0');
                        
                        if(dir == 'N') {
                            rowCol = move(park, row, col, -1, 0, -1, dist);
                        } else if(dir == 'S') {
                            rowCol = move(park, row, col, 1, 0, park.length, dist);
                        } else if(dir == 'E') {
                            rowCol = move(park, row, col, 0, 1, park[0].length(), dist);
                        } else if(dir == 'W') {
                            rowCol = move(park, row, col, 0, -1, -1, dist);
                        }
                        
                        if(!(rowCol[0] == -1 && rowCol[1] == -1)) {
                            row = rowCol[0]; col = rowCol[1];
                        }
                    }
                    
                    return new int[]{row, col};
                }
            }
        }
        
        return new int[]{0, 0};
    }
}