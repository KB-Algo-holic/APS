// PGM 42889 - 실패율
// 우선순위 큐, 정렬
// https://school.programmers.co.kr/learn/courses/30/lessons/42889

import java.util.*;

class StageSurviveRate implements Comparable<StageSurviveRate>{
    double surviveRate;
    int stage;

    StageSurviveRate(double surviveRate, int stage) {
        this.surviveRate = surviveRate;
        this.stage = stage;
    }

    @Override
    public int compareTo(StageSurviveRate other) {
        if(other.surviveRate == this.surviveRate) {
            return this.stage >= other.stage ? 1 : -1;
        } else {
            return other.surviveRate > this.surviveRate ? 1 : -1;
        }
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        int[] players = new int[N + 1];
        for(int i = 0; i < stages.length; i++) {
            if(stages[i] > N) {
                continue;
            }

            players[stages[i]]++;
        }

        PriorityQueue<StageSurviveRate> pq = new PriorityQueue<>();

        int minusPlayer = 0;
        for(int i = 1; i < players.length; i++){
            double surviveRate = (double)players[i] / (double)(stages.length - minusPlayer);

            if(stages.length == minusPlayer) {
                pq.add(new StageSurviveRate(0.0d, i));
            } else {
                pq.add(new StageSurviveRate(surviveRate, i));
            }

            minusPlayer += players[i];
        }

        int index = 0;
        while(pq.size() > 0) {
            answer[index++] = pq.poll().stage;
        }

        return answer;
    }
}