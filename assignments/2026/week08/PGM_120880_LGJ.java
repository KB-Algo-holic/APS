// PGM - 120880
// 구현 - 정렬
// https://school.programmers.co.kr/learn/courses/30/lessons/120880


class Solution {
    public int[] solution(int[] numlist, int n) {

        for (int i=0; i<numlist.length-1; i++) {
            for (int j=0; j<numlist.length-1-i; j++) {
                int dist1 = Math.abs(numlist[j]-n);
                int dist2 = Math.abs(numlist[j+1]-n);
                if (dist1 > dist2) {
                    int temp = numlist[j];
                    numlist[j] = numlist[j+1];
                    numlist[j+1] = temp;
                } else if (dist1 == dist2 && numlist[j] < numlist[j+1]) {
                    int temp = numlist[j];
                    numlist[j] = numlist[j+1];
                    numlist[j+1] = temp;
                }
            }

        }


        return numlist;
    }
}