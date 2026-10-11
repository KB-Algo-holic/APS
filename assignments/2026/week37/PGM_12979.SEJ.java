// https://school.programmers.co.kr/learn/courses/30/lessons/12979
class Solution {
    public int solution(int n, int[] stations, int w) {
        int result = 0;
        int preIdx = 1;
        int black = 0;
        for(int station : stations){
            black = station - preIdx - w;
            
            if(black > 0){
                result += calc(black, w);
            }

            //result+=calc(black, w);
            //System.out.println(black+"개의 불이 안들어와서 "+calc(black, w)+"개 추가!!");
            
            preIdx = station+w+1;
        }
        
        //System.out.println("마지막 인덱스는???" + preIdx);
        if(preIdx<=n){
            black = n - preIdx+1;
            result+=calc(black, w);
            //System.out.println(black+"개의 불이 안들어와서 "+calc(black, w)+"개 추가!!");
        }
        
        return result;
    }
    
    int calc(int n, int w){
        w*=2;
        w+=1;
        int result = n/w;
        if(n%w!=0){
            result+=1;
        }
        
        return result;
    }
}
