// PGM 120880 - 특이한 정렬
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/120880
class Solution {
    public int[] solution(int[] numlist, int n) {

        int nLength = numlist.length-1;

        for(int i=0;i<nLength;i++){
            for(int j=0;j<nLength-i;j++){

                int current = numlist[j];
                int target = numlist[j+1];

                int desCur = (current>n) ? current-n : n-current;
                int desTarget = (target>n) ? target-n : n-target;

                if (desCur>desTarget || (desCur==desTarget && current<target)) {
                    int temp = numlist[j];
                    numlist[j] = numlist[j+1];
                    numlist[j+1] = temp;
                }
            }
        }
        return numlist;
    }
}