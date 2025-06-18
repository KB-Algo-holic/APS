# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 42840 - 모의고사
# 유형: 완전탐색
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42840

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[][] pattern = {
            {1, 2, 3, 4, 5}
            , {2, 1, 2, 3, 2, 4, 2, 5}
            , {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int length = pattern.length;
        
        int[] tot = new int[pattern.length];
        for(int i = 0; i < answers.length; i++)
            for(int j = 0; j < length; j++ )
                if(answers[i] == pattern[j][i % pattern[j].length])
                    tot[j]++;
        
        PriorityQueue<Student> pq = new PriorityQueue<>();
        for(int i = 0; i < length; i++)
            pq.offer(new Student(i + 1, tot[i]));
        
        List<Integer> list = new ArrayList<>();
        Student max = pq.poll();
        list.add(max.no);
        
        while(!pq.isEmpty() && pq.peek().score == max.score)
            list.add(pq.poll().no);
        
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    
    private class Student implements Comparable<Student> {
        int no, score;
        
        public Student(int no, int score) {
            this.no = no;
            this.score = score;
        }
        
        @Override
        public int compareTo(Student o) {
            if(this.score == o.score)
                return Integer.compare(this.no, o.no);
            
            return Integer.compare(o.score, this.score);
        }
    }
}