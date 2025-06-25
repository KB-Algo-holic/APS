// PGM 172927 - 광물캐기
// 유형: 그리디
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/172927

import java.util.*;

/*
    0 - Diamond Pick    =   1 / 1 / 1
    1 - Iron Pick       =   5 / 1 / 1
    2 - Stone Pick      =   25 / 5 / 1

    1. mineral에 25 / 5 / 1 의 가중치를 주고
    2. 앞에서부터 5개씩 묶은 minerals의 가중치 값에 따라 내림차순 정렬
    3. minerals 그룹의 수 > 곡괭이의 수라면 곡괭이의 수만큼만 그룹을 묶는다.
    4. 최소치를 구하기 위해 Diamond -> Iron -> Stone 순서로 곡괭이를 사용
    5. minerals를 다 캤다면 종료.
*/

class Group{
    int tiredPoint;
    int index;

    Group(int tiredPoint, int index){
        this.tiredPoint = tiredPoint;
        this.index = index;
    }
}

class Solution {

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        List<Group> list = new ArrayList<>();

        int picksCount = Arrays.stream(picks).sum() * 5;
        int tiredPoint = 0;
        int mineralCount = 0;
        int index = 0;
        int calcCount = 0;

        for(String mineral : minerals){
            mineralCount++;
            picksCount--;
            calcCount++;

            switch(mineral){
                case "diamond" -> tiredPoint += 25;
                case "iron" -> tiredPoint += 5;
                case "stone" -> tiredPoint += 1;
            }

            if(picksCount == 0){
                break;
            }

            if(mineralCount == 5){
                list.add(new Group(tiredPoint, index));
                tiredPoint = 0;
                mineralCount = 0;
                index+=5;
            }
        }

        if(mineralCount > 0){
            list.add(new Group(tiredPoint, index));
        }

        Collections.sort(list, (a, b) -> (b.tiredPoint - a.tiredPoint));

        int[] picksPower = {25, 5, 1};

        for(Group g : list){
            int target = g.index;
            int pick = -1;

            for(int i = 0; i < 3; i++){
                if(picks[i] > 0){
                    pick = i;
                    picks[i]--;
                    break;
                }
            }

            if(pick == -1){
                break;
            }

            for(int i = target; i < Math.min(target + 5, calcCount); i++){
                switch(minerals[i]){
                    case "diamond" -> answer += Math.max(25 / picksPower[pick], 1);
                    case "iron" -> answer += Math.max(5 / picksPower[pick], 1);
                    case "stone" -> answer += 1;
                }
            }
        }

        return answer;
    }
}