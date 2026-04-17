// PGM 172928 - 공원 산책
// 구현
// school.programmers.co.kr/learn/courses/30/lessons/172928?language=java#
class Solution {
    public int[] solution(String[] park, String[] routes) {
                
        int maxX = park[0].length() -1;
        int maxY = park.length - 1;        
                
        int x = 0;
        int y = 0;
        String[][] var = new String[maxY + 1][maxX + 1];
        
        for(int i = 0; i <= maxY; i++) {
            for(int j = 0; j <= maxX; j++) {
                var[i][j] = park[i].charAt(j) + "";
                if(var[i][j].equals("S")) {
                    x = j;
                    y = i;
                }
            }
        }
        
        int tempX = x;
        int tempY = y;
        int a = 0;
        boolean xx = false;
        
        for(int i = 0; i < routes.length; i++) {
            tempX = x;
            tempY = y;
            a = Integer.parseInt(routes[i].substring(2,3));
            xx = false;
            if('E' == routes[i].charAt(0)) {
                tempX = tempX + a;
                if(tempX > maxX) continue;
                for(int z = x + 1; z <= tempX; z++) {
                    if("X".equals(var[y][z])) {
                        xx = true;
                        break;
                    }
                }
                if(!xx) {
                    x = tempX;
                }            
                
            } else if('W' == routes[i].charAt(0)) {                
                tempX = tempX - a;
                if(tempX < 0) continue;
                for(int z = tempX; z < x; z++) {
                    if("X".equals(var[y][z])) {                        
                        xx = true;
                        break;
                    }
                }
                if(!xx) {
                    x = tempX;
                }
                
            } else if('S' == routes[i].charAt(0)) {
                tempY = tempY + a;
                if(tempY > maxY) continue;
                for(int z = y + 1; z <= tempY; z++) {
                    if("X".equals(var[z][x])) {                        
                        xx = true;
                        break;
                    }
                }
                if(!xx) {
                    y = tempY;
                }
                
                
            } else {
                tempY = tempY - a;
                if(tempY < 0) continue;
                for(int z = tempY; z < y; z++) {
                    if("X".equals(var[z][x])) {                        
                        xx = true;
                        break;
                    }
                }
                if(!xx) {
                    y = tempY;
                }
                
            }
                
        }
        
        int[] answer = {y, x};
        return answer;
    }
}
