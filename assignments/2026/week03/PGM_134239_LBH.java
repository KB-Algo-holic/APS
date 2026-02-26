// PGM 132439 - 우박수열 정적분
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/132439

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        double[] sequence = new double[10000];
        
        // k calculate, sequence insert
        int kTemp = k;
        int index = 0;
        sequence[index++] = kTemp;
        while(kTemp != 1){
            if(kTemp % 2 == 0){
                kTemp /= 2;
            } else {
                kTemp = kTemp * 3 + 1;
            }
            
            sequence[index++] = kTemp;
        }
        
        // getWidth Sum
        double[] widthSum = new double[10001]; 
        for(int i = 1; i <= index; i++){
            double triangle = Math.abs(sequence[i] - sequence[i-1]) / 2;
            double square = sequence[i - 1] < sequence[i] ? sequence[i - 1] : sequence[i];
            widthSum[i] = widthSum[i-1] + triangle + square;
        }
        
        index--;
        // input range, calculate width function
        for(int i = 0; i < ranges.length; i++){
            int start = ranges[i][0];
            int end = index + ranges[i][1];
            
            if(end < start){
                answer[i] = -1.0;
            } else if(end == start) {
                answer[i] = 0.0;
            } else {
                answer[i] = widthSum[end] - widthSum[start];
            }    
        }
        
        return answer;
    }
}
