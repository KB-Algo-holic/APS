// PGM 172928 - 공원 산책 
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/172928

class Solution {
    public int[] solution(String[] park, String[] routes) {
        
        int r = 0;
        int c = 0;
        boolean startYn = false;
        int h = park.length -1;
        int w = park[0].length() -1;
        
        for(int i = 0 ; i<park.length ; i++){  //스타트 찾기
            
            if(park[i].indexOf("S") > -1){
                r = i;
                c = park[i].indexOf("S");
                break;
            }
        }
        
        for(int i = 0 ; i<routes.length ; i++){
            
            String[] dirMov = routes[i].split(" ");
            String dir = dirMov[0];
            int mov = Integer.parseInt(dirMov[1]);
            
            if("E".equals(dir)){
                    
                if(w < c+mov)
                    continue;
                
                if(park[r].substring(c+1,c+mov+1).contains("X"))
                    continue;
                
                c += mov;
            }
            else if("W".equals(dir)){
                
                if(c - mov < 0)
                    continue;
                
                if(park[r].substring(c-mov,c).contains("X"))
                    continue;
                
                c -= mov;
                
            }
            else if("S".equals(dir)){
                
                if(r+mov > h)
                    continue;
                
                boolean isBlocked = false;
                
                for(int tempR = r+1 ; tempR<= r+mov ;tempR++){
                    
                    if(park[tempR].substring(c,c+1).contains("X")){
                        isBlocked = true; 
                        break;
                    }
                    
                }
                if(isBlocked)
                    continue;
                
                r += mov;
            }
            else if("N".equals(dir)){
                    
                if(r-mov < 0)
                    continue;
                
                boolean isBlocked = false;
                
                for(int tempR = r-mov ; tempR< r ;tempR++){
                    
                    if(park[tempR].substring(c,c+1).contains("X")){
                        isBlocked = true; 
                        break;
                    } 
                }
                if(isBlocked)
                    continue;
                
                r -= mov; 
            }     
        
        }
              
        return new int[]{r,c};
    }
}
