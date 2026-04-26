// PGM_172928 공원 산책
// 매트릭스 만들어서 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/172928
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {0, 0};
        int[][] matrix = new int[park.length][park[0].length()];
        for(int i = 0 ; i < park.length; i++){
            for(int j = 0; j < park[i].length(); j++){
                if(park[i].charAt(j) == 'S'){
                    matrix[i][j] = 1;
                    answer = new int[] {i, j};
                }
                else if(park[i].charAt(j) == 'O'){
                    matrix[i][j] = 1;
                }
                else{
                    matrix[i][j] = 0;
                }
            }
        }
        
        for(String str : routes){
            String[] sbs = str.split(" ");
            if(sbs[0].equals("E")){
                if(answer[1] + Integer.parseInt(sbs[1]) >= matrix[0].length){
                    continue;
                }
                else{
                    int[] now = answer;
                    boolean flg = true;
                    for(int i = now[1] + 1; i <= Integer.parseInt(sbs[1]) + now[1]; i++){
                        if(matrix[now[0]][i] == 0){
                            flg = false;
                            break;
                        }
                    }
                    if(flg){
                        answer[1] += Integer.parseInt(sbs[1]);
                    }
                }
            }
            if(sbs[0].equals("W")){
                if(answer[1] - Integer.parseInt(sbs[1]) < 0){
                    continue;
                }
                else{
                    int[] now = answer;
                    boolean flg = true;
                    for(int i = now[1] - 1; i >= now[1] - Integer.parseInt(sbs[1]); i--){
                        if(matrix[now[0]][i] == 0){
                            flg = false;
                            break;
                        }
                    }
                    if(flg){
                        answer[1] -= Integer.parseInt(sbs[1]);
                    }
                }
            }
            
            if(sbs[0].equals("N")){
                if(answer[0] - Integer.parseInt(sbs[1]) < 0){
                    continue;
                }
                else{
                    int[] now = answer;
                    boolean flg = true;
                    for(int i = now[0] - 1; i >= now[0] - Integer.parseInt(sbs[1]); i--){
                        if(matrix[i][now[1]] == 0){
                            flg = false;
                            break;
                        }
                    }
                    if(flg){
                        answer[0] -= Integer.parseInt(sbs[1]);
                    }
                }
            }
            
            if(sbs[0].equals("S")){
                if(answer[0] + Integer.parseInt(sbs[1]) >= matrix.length){
                    continue;
                }
                else{
                    int[] now = answer;
                    boolean flg = true;
                    for(int i = now[0] + 1; i <= now[0] + Integer.parseInt(sbs[1]); i++){
                        if(matrix[i][now[1]] == 0){
                            flg = false;
                            break;
                        }
                    }
                    if(flg){
                        answer[0] += Integer.parseInt(sbs[1]);
                    }
                }
            }
        }
               
        return answer;
    }
}
