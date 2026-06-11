// PGM 154540 - 무인도 여행
// BFS/DFS
// https://school.programmers.co.kr/learn/courses/30/lessons/154540

import java.util.*;

class Solution {

    static int[][] map;
    static boolean[][] chk;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int sum, xl, yl;

    public int[] solution(String[] maps) {

        map = new int[maps.length][maps[0].length()];
        chk = new boolean[maps.length][maps[0].length()];
        xl = maps.length;
        yl = maps[0].length();

        System.out.print(Arrays.deepToString(chk));

        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                if(maps[i].charAt(j) == 'X')
                    map[i][j] = -1;
                else
                    map[i][j] = maps[i].charAt(j) -'0';
            }
        }


        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                if(map[i][j] != -1 && !chk[i][j]){
                    //System.out.println(map[i][j]);
                    sum = map[i][j];
                    chk[i][j] = true;
                    move(i,j);
                    list.add(sum);
                    //System.out.println(sum);
                }
            }
        }

        //System.out.print(Arrays.deepToString(map));
        //System.out.print(Arrays.deepToString(chk));

        int[] answer;
        if(list.size() == 0){
            answer = new int[1];
            answer[0] = -1;
        }else{
            answer = new int[list.size()];
            for(int i = 0; i < list.size(); i++){
                answer[i] = list.get(i);
            }
        }

        Arrays.sort(answer);

        return answer;
    }

    public static void move(int i, int j){

        for(int k = 0; k < 4; k++){
            if(i+dx[k] >=0 && j+dy[k] >= 0 && i+dx[k] < xl && j+dy[k] < yl && map[i+dx[k]][j+dy[k]] > 0 && !chk[i+dx[k]][j+dy[k]]){
                sum += map[i+dx[k]][j+dy[k]];
                chk[i+dx[k]][j+dy[k]] = true;
                move(i+dx[k], j+dy[k]);
            }
        }
    }
}