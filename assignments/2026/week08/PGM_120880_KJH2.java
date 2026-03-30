// PGM_120880 특이한 정렬
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/120880

class Solution {
    public int[] solution(int[] numlist, int n) {
        for(int i = 0; i < numlist.length - 1; i++){
            for(int j = i + 1; j < numlist.length; j++){
                if(Math.abs(numlist[i] - n) > Math.abs(numlist[j] - n) || 
                   Math.abs(numlist[i] - n) == Math.abs(numlist[j] - n) && numlist[i] < numlist[j]){
                    int tmp = numlist[i];
                    numlist[i] = numlist[j];
                    numlist[j] = tmp;
                }
            }
        }
        
        return numlist;
    }
}